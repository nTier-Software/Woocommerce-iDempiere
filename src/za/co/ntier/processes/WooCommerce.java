package za.co.ntier.processes;

import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.Woocommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import za.co.ntier.model.X_zz_woocommerce;
import za.co.ntier.woocommerce.WcOrder;

/**
 *
 * Start a thread to collect unsynchronised orders from WooCommerce website
 *
 * @author yogan naidoo
 */

public class WooCommerce extends SvrProcess {

	public class MyRunnable implements Runnable {

		@Override
		public void run() {

			// Get WooCommerce defaults
			final PO wcDefaults;
			String whereClause = " isactive = 'Y' AND AD_Client_ID = ?";
			wcDefaults = new Query(getCtx(), X_zz_woocommerce.Table_Name, whereClause, null)
					.setParameters(new Object[] { Env.getAD_Client_ID(getCtx()) }).firstOnly();
			if (wcDefaults == null)
				throw new IllegalStateException("/nWooCommerce Defaults need to be set on iDempiere /n");

			// Setup client
			OAuthConfig config = new OAuthConfig((String) wcDefaults.get_Value("url"),
					(String) wcDefaults.get_Value("consumerkey"), (String) wcDefaults.get_Value("consumersecret"));
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
				WcOrder wcOrder = new WcOrder(getCtx(), get_TrxName(), wcDefaults);
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

				/*
				 * // Update syncedToIdempiere to 'yes' Map<String, Object> body = new
				 * HashMap<>(); List<Map<String, String>> listOfMetaData = new ArrayList();
				 * Map<String, String> metaData = new HashMap<>(); metaData.put("key",
				 * "syncedToIdempiere"); metaData.put("value", "yes");
				 * listOfMetaData.add(metaData);
				 * 
				 * body.put("meta_data", listOfMetaData); Map<?, ?> response =
				 * wooCommerce.update(EndpointBaseType.ORDERS.getValue(), id, body);
				 * System.out.println(response.toString());
				 */
			}
		}

	}

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		Thread thread = new Thread(new MyRunnable());
		thread.start();

		return "Synchronisation to WooCommerce initiated";
	}

}
