package com.toba.nick2905.kubatak.ui.Kamus

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Kamus
import kotlinx.android.synthetic.main.activity_kamus.*
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*

class KamusActivity : AppCompatActivity() {
    private lateinit var adapterKamus: KamusAdapter
    private var TAG = "MainActivity"
    private var arrayList: ArrayList<Kamus> = ArrayList<Kamus>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kamus)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapterKamus = KamusAdapter(this, arrayList)
        recyclerView.adapter = adapterKamus
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.viewTreeObserver.addOnScrollChangedListener {
            var x = toolbar.scrollX
            var y = toolbar.scrollY
        }

        addItemFromJSON()

    }

    private fun addItemFromJSON() {
        try {
            val jsonDataString = readJSONDataFromFile()
            val jsonArray = JSONArray(jsonDataString)
            for (i in 0 until jsonArray.length()) {
                val itemObject = jsonArray.getJSONObject(i)
                val kamusBatak = itemObject.getString("kamusBatak")
                val artiIndonesia = itemObject.getString("artiIndonesia")
                val model = Kamus(kamusBatak, artiIndonesia)
                arrayList.add(model)
            }
        } catch (e: JSONException) {
            Log.d(TAG, "addItemFromJSON: ", e)
        } catch (e: IOException) {
            Log.d(TAG, "addItemFromJSON: ", e)
        }
    }

    @Throws(IOException::class)
    private fun readJSONDataFromFile(): String? {
        var inputStream: InputStream? = null
        val builder = StringBuilder()
        try {
            var jsonstring: String? = null
            inputStream = resources.openRawResource(R.raw.kamus)
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, StandardCharsets.UTF_8)
            )
            while (bufferedReader.readLine().also { jsonstring = it } != null) {
                builder.append(jsonstring)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val myActionMenuItem = menu!!.findItem(R.id.action_search)
        val searchView =
            myActionMenuItem.actionView as SearchView
        searchView.queryHint = "Cari Arti Kata"
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                if (TextUtils.isEmpty(s)) {
                    adapterKamus.filter("")
                } else {
                    adapterKamus.filter(s)
                }
                return true
            }
        })
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
