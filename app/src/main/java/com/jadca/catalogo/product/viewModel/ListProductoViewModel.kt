package com.jadca.catalogo.product.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jadca.catalogo.infrastructure.response.DataResponse
import com.jadca.catalogo.product.model.IProductoRepository
import com.jadca.catalogo.product.model.productoModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import kotlin.math.log

class ListProductoViewModel ():ViewModel(){
    private  val _productoRepository by inject(IProductoRepository::class.java)
    private var _productoModel=MutableLiveData<List<productoModel>>()
    val productoModel:LiveData<List<productoModel>> get()=_productoModel
    private var _onMessageError = MutableLiveData<String>()
    val onMessageError: LiveData<String> get() = _onMessageError

    init {
        viewModelScope.launch {
            _productoRepository.GetAllX2().collect {
                validateResult(DataResponse.Success<List<productoModel>>(it))
            }
        }
    }
    private fun validateResult(result: DataResponse<List<productoModel>>) {
        when (result) {
            is DataResponse.ExceptionError -> _onMessageError.postValue(result.errorCode.message)
            is DataResponse.ServerError -> _onMessageError.postValue(result.errorCode.message)
            is DataResponse.Success -> _productoModel.postValue(result.data)
            is DataResponse.TimeOutException -> _onMessageError.postValue(result.errorCode.message)
        }
    }
}