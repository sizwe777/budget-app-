package com.example.budgettrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpensesAdapter(private var expenses: List<Expenses>) : RecyclerView.Adapter<ExpensesAdapter.ExpenseViewHolder>() {

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDate: TextView = itemView.findViewById(R.id.textDate)
        val textDesc: TextView = itemView.findViewById(R.id.textDesc)
        val textAmount: TextView = itemView.findViewById(R.id.textAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun getItemCount(): Int = expenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.textDate.text = expense.date
        holder.textDesc.text = expense.description
        holder.textAmount.text = expense.amount.toString()  // Format as needed
    }

    fun updateData(newExpenses: List<Expenses>) {
        expenses = newExpenses
        notifyDataSetChanged()
    }
}