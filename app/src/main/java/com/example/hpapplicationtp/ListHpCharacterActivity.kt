package com.example.hpapplicationtp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hpapplicationtp.configurations.RetrofitClient
import com.example.hpapplicationtp.dtos.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListHpCharacterActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var charactersAdapter: CharactersAdapter

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hp_character)

        recyclerView = findViewById(R.id.recyclerViewCharacters)
        recyclerView.layoutManager = LinearLayoutManager(this)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)


        charactersAdapter = CharactersAdapter(emptyList()) { character ->
            // Este bloque se ejecuta cuando se hace clic en un personaje
            val intent = Intent(this, CharacterDetailActivity::class.java)
            intent.putExtra("character", character)
            startActivity(intent)
        }

        recyclerView.adapter = charactersAdapter

        fetchAllCharacters()
    }

    private fun fetchAllCharacters() {
        val call = RetrofitClient.postService.getAllCharacters()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val characters = response.body()
                    characters?.let {
                        charactersAdapter.updateCharacters(it)
                    } ?: run {
                        showError("No data available")
                    }
                } else {
                    showError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                showError("Failed to load data: ${t.message}")
            }
        })
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_volver){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}
