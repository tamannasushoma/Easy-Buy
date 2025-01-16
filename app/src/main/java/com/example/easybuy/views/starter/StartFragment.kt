package com.example.easybuy.views.starter

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.example.easybuy.R
import com.example.easybuy.base.BaseFragment
import com.example.easybuy.databinding.FragmentStartBinding
import com.example.easybuy.views.dashboard.seller.SellerDashboard
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {


    override fun setListener() {

        setupAutoLogin()
        with(binding){
            loginBtn.setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            registerBtn.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }
        }
    }

    private fun setupAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let{
           startActivity(Intent(requireContext(), SellerDashboard::class.java))
            requireActivity().finish()
        }
    }

    override fun allObserver() {
    }

}