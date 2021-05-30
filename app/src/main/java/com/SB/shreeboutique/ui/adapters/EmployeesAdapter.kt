package com.SB.shreeboutique.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.SB.shreeboutique.R
import com.SB.shreeboutique.db.Employee

class EmployeesAdapter : RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>() {
    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_employeeName: TextView = view.findViewById(R.id.tv_employeeName)
        val tv_position: TextView = view.findViewById(R.id.tv_position)
        val tv_employeeSalary: TextView = view.findViewById(R.id.tv_employeeSalary)
        val tv_employeeDate: TextView = view.findViewById(R.id.tv_employeeDate)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_single_layout, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = differ.currentList[position]
        holder.itemView.apply {
            holder.tv_employeeName.text = employee.name
            holder.tv_position.text = employee.position
            holder.tv_employeeSalary.text = employee.salary.toString()
            holder.tv_employeeDate.text = employee.dateOfJoining
            setOnItemClickListener {
                onItemClickListener?.let { it(employee) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Employee) -> Unit)? = null
    fun setOnItemClickListener(listener: (Employee) -> Unit) {
        listener.also { onItemClickListener = it }
    }
}