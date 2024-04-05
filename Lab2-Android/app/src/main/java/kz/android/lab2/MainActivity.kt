package kz.android.lab2

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.lab2.adapters.CatAdapter
import kz.android.lab2.api.Repository
import kz.android.lab2.databinding.ActivityMainBinding
import kz.android.lab2.model.CatBreed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    val adapter = CatAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding){
            catList.adapter = adapter
            catList.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            etSearch.setOnEditorActionListener { it, actionId, _ ->
                if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(it.text.toString())
                    true
                } else false
            }
        }
        setContentView(binding.root)

    }
    private fun performSearch(query: String) {
        Repository.api.getCatBreedByName(query).enqueue(object :
            Callback<List<CatBreed>> {
            override fun onResponse(call: Call<List<CatBreed>>, response: Response<List<CatBreed>>) {
                if (response.isSuccessful) {
                  adapter.submitList(response.body())
                }
            }
            override fun onFailure(call: Call<List<CatBreed>>, t: Throwable) {
            }
        })
    }
}