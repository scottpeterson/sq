package com.square.takehome.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.square.takehome.api.Employee
import com.square.takehome.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class EmployeeDirectoryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val employeeLiveData = MutableLiveData<List<Employee>>()

    fun getEmployeeData() = employeeLiveData

    init {
        loadEmployees()
    }

    private fun loadEmployees() {
        viewModelScope.launch {
            try {
                val employees = repository.getEmployees()
                employeeLiveData.postValue(employees)
            } catch (e: Error) {
                Timber.e(e)
            }
        }
    }

}






