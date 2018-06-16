package com.neemre.btcdcli4j.examples.client;

import com.neemre.btcdcli4j.core.client.BtcdClient;
import com.neemre.btcdcli4j.core.domain.enums.CheckLevels;
import com.neemre.btcdcli4j.examples.util.ResourceUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Properties;

/**A list of examples demonstrating the use of <i>bitcoind</i>'s block chain RPCs (via the JSON-RPC 
 * API).*/
public class BlockChainApi {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpProvider = ResourceUtils.getHttpProvider();
		Properties nodeConfig = ResourceUtils.getNodeConfig();
		BtcdClient client = new VerboseBtcdClientImpl(httpProvider, nodeConfig);

		client.getBestBlockHash();
		client.getBlock("00000000000000e8cf3d4fab91c642f5d5bb13339613aa915a42a7f1c91ab5ba", 0);
		client.getBlock("00000000000000e8cf3d4fab91c642f5d5bb13339613aa915a42a7f1c91ab5ba", 0);
		client.getBlockChainInfo();
		client.getBlockCount();
		client.getBlockHash(345168);
		client.getChainTips();
		client.getDifficulty();
		client.getMemPoolInfo();
		client.getRawMemPool();
		client.getRawMemPool(true);
		client.getTxOutSetInfo();
		client.verifyChain();
		client.verifyChain(CheckLevels.LEVEL_4.getIdentifier());
		client.verifyChain(CheckLevels.LEVEL_4.getIdentifier(), 1000);
	}
}