package com.kyoudai.travelbuddy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyoudai.travelbuddy.models.Trip

class HomeViewModel : ViewModel() {

    private val _tripList = MutableLiveData<List<Trip>>().apply {
        value = listOf(
            Trip("Trip to Germany",
                "A test row for a trip to Germany",
                "https://www.railbookers.co.uk/sites/railbookers/files/styles/hero/public/media/images/rothenburg-bavaria-germany_1132137539_web_0.jpg?"
            ),
            Trip("Trip to Iceland",
                "A test row for a trip to Iceland",
                "https://images.travelandleisureasia.com/wp-content/uploads/sites/3/2024/02/12190030/Kirkjufell-1600x900.jpg"
            ),
        )
    }

    val tripList: LiveData<List<Trip>> = _tripList;
}