package online.scattergories.android.core

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import okhttp3.OkHttpClient

object ScattergoriesOnline {
    val okHttpClient = OkHttpClient.Builder().build()
    val apolloClient = ApolloClient.builder()
        .serverUrl("https://localhost:3000/v1/graphql")
        .subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory("wss://localhost:3000/v1/graphql", okHttpClient))
        .okHttpClient(okHttpClient)
        .build()
}