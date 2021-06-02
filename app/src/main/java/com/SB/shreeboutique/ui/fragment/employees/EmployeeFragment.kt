package com.SB.shreeboutique.ui.fragment.employees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.SB.shreeboutique.R
import com.SB.shreeboutique.ui.activity.Employees
import com.SB.shreeboutique.ui.adapters.EmployeesAdapter
import com.SB.shreeboutique.ui.viewmodels.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class EmployeeFragment : Fragment(R.layout.fragment_employee) {
    lateinit var fabEmployee: FloatingActionButton
    lateinit var rv_employee: RecyclerView
    lateinit var employeesAdapter: EmployeesAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_employee, container, false)
        initialization(view)

        employeesAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("employee", it)
            }
            findNavController().navigate(R.id.action_employeeFragment_to_updateFragment, bundle)
        }

        rv_employee.apply {
            adapter = employeesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getAllEmployees().observe(viewLifecycleOwner, Observer { employee ->
            employeesAdapter.differ.submitList(employee)
        })

        val itemTouchHelper = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val employee = employeesAdapter.differ.currentList[position]
                viewModel.delete(employee)

                Snackbar.make(
                    rv_employee,
                    "${employee.name} Deleted Successfully!!",
                    Snackbar.LENGTH_LONG
                ).setAction("Undo") { viewModel.insert(employee) }.show()

            }
        }

        ItemTouchHelper(itemTouchHelper).attachToRecyclerView(rv_employee)

        fabEmployee.setOnClickListener {
            findNavController().navigate(R.id.action_employeeFragment_to_newEmployeeFragment)
        }
        return view

    }

    private fun initialization(view: View) {
        viewModel = (activity as Employees).viewModel
        employeesAdapter = EmployeesAdapter()
        fabEmployee = view.findViewById(R.id.fab_add_employee)
        rv_employee = view.findViewById(R.id.rv_employee)
    }
}