package za.co.ntier.processes;

import org.compiere.model.MOrder;
import org.compiere.process.SvrProcess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import za.co.ntier.woocommerce.WcOrder;

public class WooCommerce extends SvrProcess {

	
	public class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("My runnable is running");
			
			// Setup client
			OAuthConfig config = new OAuthConfig("https://dazzle.co.za/wctest",
					"ck_925b78b0d4a38082e6888c3fe52454d8b09348d2", "cs_6196075ca314adf2f31239fb2cd20bceaeb45120");
			Woocommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);

			// Get all with request parameters
			Map<String, String> params = new HashMap<>();
			params.put("per_page", "100");
			params.put("offset", "0");
			params.put("meta_key", "syncedToIdempiere");
			params.put("meta_value", "yes");
			params.put("status", "completed");
			
			List<?> wcOrders = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);
			// Iterate through each order
			for (int i = 0; i < wcOrders.size(); i++) {
				Map<?, ?> order = (Map<?, ?>) wcOrders.get(i);
				System.out.println("Order- " + order.get("id") + ": " + order);
				WcOrder wcOrder =  new WcOrder(getCtx(), get_TrxName());
				wcOrder.createOrder(order);

				// Iterate through each order Line
				List<?> lines = (List<?>) order.get("line_items");
				for (int j = 0; j < lines.size(); j++) {
					Map<?, ?> line = (Map<?, ?>) lines.get(j);
					wcOrder.createOrderLine(line, order);
					Object name = line.get("name");
					System.out.println("Name of Product = " + name.toString());
				}
				wcOrder.createShippingCharge(order);
				wcOrder.createPosPayment(order);
				wcOrder.completeOrder();
				
				/*// Update syncedToIdempiere to 'yes'
				Map<String, Object> body = new HashMap<>();
				List<Map<String, String>> listOfMetaData = new ArrayList();
				Map<String, String> metaData = new HashMap<>();
				metaData.put("key", "syncedToIdempiere");
				metaData.put("value", "yes");
				listOfMetaData.add(metaData);

				body.put("meta_data", listOfMetaData);
				Map<?, ?> response = wooCommerce.update(EndpointBaseType.ORDERS.getValue(), id, body);
				System.out.println(response.toString()); */
			}
			System.out.println("My runnable is finished");
		}
		
	}
	
	@Override
	protected void prepare() {
		log.warning("--------------In the prepare method");
	}

	@Override
	protected String doIt() throws Exception {
		log.warning("--------------In the doIt method");
		Thread thread = new Thread(new MyRunnable() );
		thread.start();
		log.warning("--------------Exiting doIt method");

		return "Success";
	}

}
