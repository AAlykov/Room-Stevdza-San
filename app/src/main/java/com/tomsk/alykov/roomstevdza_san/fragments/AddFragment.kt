package com.tomsk.alykov.roomstevdza_san.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tomsk.alykov.roomstevdza_san.R
import com.tomsk.alykov.roomstevdza_san.data.User
import com.tomsk.alykov.roomstevdza_san.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstName = editTextTextPersonName.text.toString()
        val lastName = editTextTextPersonName2.text.toString()
        val age = editTextNumber.text.toString()

        val user = User(0, firstName, lastName, Integer.parseInt(age))
        mUserViewModel.addUser(user)
        Toast.makeText(requireContext(), "Add ok", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)


    }



}