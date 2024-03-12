package com.example.colleagueclockin.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}


//It's a container class that we return in our repository in our use cases
// and we can wrap around our data and error messages.