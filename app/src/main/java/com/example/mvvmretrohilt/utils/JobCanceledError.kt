package com.example.mvvmretrohilt.utils

class JobCanceledError(
    code: Int,
    msg: String,
) : Error(code, msg)