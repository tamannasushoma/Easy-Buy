package com.example.easybuy.views.register

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.easybuy.R
import com.example.easybuy.base.BaseFragment
import com.example.easybuy.core.DataState
import com.example.easybuy.databinding.FragmentRegisterBinding
import com.example.easybuy.isEmpty
import com.example.easybuy.views.dashboard.seller.SellerDashboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

private val viewModel: RegistrationViewModel by viewModels()



    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()

                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "created user data:---> ${it.data}", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(), SellerDashboard::class.java))
                    requireActivity().finish()



                }
            }
        }
    }

    override fun setListener() {
        with(binding){
            notregButton.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            regButton.setOnClickListener {
                inputRegName.isEmpty()
                inputRegEmail.isEmpty()
                inputRegPassword.isEmpty()

                if(!inputRegName.isEmpty() && !inputRegEmail.isEmpty() && !inputRegPassword.isEmpty()){
//                    Toast.makeText(context, "All Input done", Toast.LENGTH_LONG).show()

                    val user = UserRegister(
                        inputRegName.text.toString(),
                        inputRegEmail.text.toString(),
                        inputRegPassword.text.toString(),
                        "seller",
                        ""
                    )

                    viewModel.userRegistration(user)
                }
            }
        }
    }

    override fun allObserver() {
        registrationObserver()
    }

}