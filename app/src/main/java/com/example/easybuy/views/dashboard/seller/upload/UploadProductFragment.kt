package com.example.easybuy.views.dashboard.seller.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easybuy.R

/**
 * A simple [Fragment] subclass.
 * Use the [UploadProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UploadProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload_product, container, false)
    }

}