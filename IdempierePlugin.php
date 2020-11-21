<?php
/**
 * Plugin Name: iDempiere
 * Plugin URI: https://wiki.idempiere.org/en/Category:Available_Plugins
 * Description: Plugin to facilitate order integration to iDempiere ERP
 * Version: 1.0
 * Author: Yogan Naidoo
 * Author URI: http://www.ntier.co.za
 */
 
add_action('woocommerce_order_status_completed','wdm_add_field_to_order_meta',1,2);
if(!function_exists('wdm_add_field_to_order_meta'))
{
  //error_log('Inside wdm_add_field_to_order_meta 1');
  function wdm_add_field_to_order_meta($order_id)
  {
	//error_log('Inside wdm_add_field_to_order_meta 2');

	$order = wc_get_order( $order_id );
    	$order->update_meta_data( 'syncedToIdempiere', 'no' );
    	$order->save();             
  }
}

if(!function_exists( 'order_meta_request_params' ) )
{
	//error_log('Inside order_meta_request_params 1');
        function order_meta_request_params($args, $request )
	{
               	//error_log('Inside order_meta_request_params 2');
                //error_log(print_r($args,true));
                //error_log(print_r($request,true));

		$args += array(
			'meta_key'   => $request['meta_key'],
			'meta_value' => $request['meta_value'],
		//	'meta_query' => $request['meta_query'],
		);

	    return $args; 
	}
	add_filter('woocommerce_rest_orders_prepare_object_query', 'order_meta_request_params', 10, 2 );
}
?>
