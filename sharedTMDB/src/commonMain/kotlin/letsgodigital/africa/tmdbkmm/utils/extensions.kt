package letsgodigital.africa.tmdbkmm.utils

import io.ktor.client.request.*
import io.ktor.http.*


fun HttpRequestBuilder.apiUrl(baseUrl: String, path: String) {
    url {
        takeFrom(baseUrl)
        encodedPath = path
    }
}
