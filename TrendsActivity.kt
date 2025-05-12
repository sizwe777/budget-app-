package com.example.budgettrackerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrendsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_trends)

        val trendsRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewTrends)
        trendsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data for trends (you can replace with dynamic data from your app's database)
        val trendsData = listOf(
            Trend("Food", 250.0),
            Trend("Entertainment", 150.0),
            Trend("Utilities", 100.0),
            Trend("Transportation", 80.0),
            Trend("Shopping", 200.0)
        )

        val adapter = TrendsAdapter(trendsData)
        trendsRecyclerView.adapter = adapter
    }
}

data class Trend(val category: String, val amount: Double)

class TrendsAdapter(private val trends: List<Trend>) : RecyclerView.Adapter<TrendsAdapter.TrendViewHolder>() {
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): TrendViewHolder {
        val view = android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_trend, parent, false)
        return TrendViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        val trend = trends[position]
        holder.bind(trend)
    }

    override fun getItemCount(): Int = trends.size

    inner class TrendViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val categoryTextView: TextView = itemView.findViewById(R.id.textCategory)
        private val amountTextView: TextView = itemView.findViewById(R.id.textAmount)

        fun bind(trend: Trend) {
            categoryTextView.text = trend.category
            amountTextView.text = "R${trend.amount}"
        }
    }
}