package com.neemre.btcdcli4j.examples.client;

import com.neemre.btcdcli4j.core.Commands;
import com.neemre.btcdcli4j.core.client.BtcdClient;
import com.neemre.btcdcli4j.examples.util.ResourceUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Properties;

/**A list of examples demonstrating the use of <i>bitcoind</i>'s control RPCs (via the JSON-RPC 
 * API).*/
public class ControlApi {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpProvider = ResourceUtils.getHttpProvider();
		Properties nodeConfig = ResourceUtils.getNodeConfig();
		BtcdClient client = new VerboseBtcdClientImpl(httpProvider, nodeConfig);

		client.getNetworkInfo();
		client.help();
		client.help(Commands.WALLET_LOCK.getName());
		client.stop();
	}
}