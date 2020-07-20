package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.repository.IRepository
import com.example.myapplication.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    PostsAdapter.OnItemClickListener {
    private val repository: IRepository = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle_view.layoutManager = LinearLayoutManager(this);
        recycle_view.setHasFixedSize(true)

        repository.getPosts(object : IRepository.Callback<List<Post>> {
            override fun onSuccess(response: List<Post>) {
                recycle_view.adapter =
                    PostsAdapter(
                        response, this@MainActivity
                    )
            }

            override fun onFailure(errorMessage: String) {
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(postId: Int) {
        val intent = Intent(this, PostCommentsActivity::class.java)
        intent.putExtra("POST_ID", postId)
        startActivity(intent)
    }
}