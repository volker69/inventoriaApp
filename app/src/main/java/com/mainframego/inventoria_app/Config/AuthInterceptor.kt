package com.mainframego.inventoria_app.Config
import okhttp3.Interceptor
import okhttp3.Response
class AuthInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${Auth.token}")
            .build()
        return chain.proceed(request)
    }
}