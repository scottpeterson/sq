package com.square.takehome.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.square.takehome.api.DataSourceError
import com.square.takehome.api.Employee
import com.square.takehome.api.SquareError
import com.square.takehome.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeDirectoryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _state = MutableStateFlow<SquareState>(SquareState.Loading)
    val state: StateFlow<SquareState>
        get() = _state.asStateFlow()

    val employeeData: MutableState<List<Employee>?> = mutableStateOf(null)

    init {
        loadEmployees()
    }

    @Throws(SquareError::class)
    fun refresh() {
        try {
            viewModelScope.launch {
                _isRefreshing.emit(true)
                employeeData.value = repository.getEmployees()
                _isRefreshing.emit(false)
            }
        } catch (e: SquareError) {
            when (e) {
                is DataSourceError.NullBody -> viewModelScope.launch {
                    _state.emit(SquareState.Empty)
                }

                else -> viewModelScope.launch {
                    _state.emit(SquareState.Error)
                }
            }
        }
    }

    @Throws(SquareError::class)
    fun loadEmployees() {
        viewModelScope.launch {
            try {
                val employees = repository.getEmployees()
                if (employees.isEmpty()) {
                    _state.emit(SquareState.Empty)
                } else {
                    employeeData.value = employees
                    _state.emit(SquareState.Loaded)
                }
            } catch (e: SquareError) {
                when (e) {
                    is DataSourceError.NullBody -> _state.emit(SquareState.Empty)
                    else -> _state.emit(SquareState.Error)
                }
            }
        }
    }
}

sealed class SquareState {
    object Loading : SquareState()
    object Empty : SquareState()
    object Error : SquareState()
    object Loaded : SquareState()
}




