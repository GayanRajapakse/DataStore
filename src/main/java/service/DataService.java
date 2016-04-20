package service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.expression.spel.ast.Indexer;

import com.google.gson.Gson;

import model.Content;

public class DataService {
	public static Client client = null;

	public DataService() {
		if (client == null) {
			client = NodeBuilder.nodeBuilder()
					.settings(Settings.builder().put("path.home", "D:\\Final Year Project\\elasticsearch-2.3.0"))
					.client(true).node().client();

			/*
			 * boolean indexExists =
			 * client.admin().indices().prepareExists("datastore").execute().
			 * actionGet().isExists(); if (!indexExists) {
			 * //client.admin().indices().prepareDelete(INDEX).execute().
			 * actionGet();
			 * client.admin().indices().prepareCreate("datastore").execute().
			 * actionGet(); }
			 */
		}
	}

	public void insertData(String user, String title, String content) {
		Content contentObj = new Content(System.currentTimeMillis(), title, content);

		IndexResponse response = client
				.prepareIndex("datastore",
						user/* , System.currentTimeMillis() + "" */)
				.setSource(new Gson().toJson(contentObj)).execute().actionGet();

		System.out.println(response);
	}

}
