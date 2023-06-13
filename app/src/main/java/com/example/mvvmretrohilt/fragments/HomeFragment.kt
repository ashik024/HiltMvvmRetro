package com.example.mvvmretrohilt.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.example.mvvmretrohilt.adapter.ListItemAdapter
import com.example.mvvmretrohilt.baseItems.BaseFragment
import com.example.mvvmretrohilt.baseItems.BaseListItemCallback
import com.example.mvvmretrohilt.modelClass.ItemClass
import com.example.mvvmretrohilt.utils.Resource
import com.example.mvvmretrohilt.utils.observe
import com.example.mvvmretrohilt.viewModel.DataViewModel
import com.example.mvvmretrohilt.widget.MarginItemDecoration

import com.example.mvvmretrohilt.databinding.FragmentHomeBinding
import com.example.mvvmretrohilt.modelClass.PhotoClass
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
//class HomeFragment : BaseFragment(), BaseListItemCallback<ItemClass> {
class HomeFragment : BaseFragment(), BaseListItemCallback<PhotoClass> {

    private val binding get() = _binding!!
    private lateinit var mAdapter: ListItemAdapter
    private var _binding: FragmentHomeBinding?=null


    private val dataViewModel by viewModels<DataViewModel>()
//    var dataViewModel: DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mAdapter = ListItemAdapter()
//
//        with(binding.planList) {
//
//            addItemDecoration(MarginItemDecoration(10))
//            adapter = mAdapter
//            setHasFixedSize(true)
//
//        }
//
//        observeList()
//        dataViewModel.loadDataViewModel()

        mAdapter = ListItemAdapter(this)
        with(binding.planList) {
            addItemDecoration(MarginItemDecoration(10))


            adapter = mAdapter
            setHasFixedSize(true)
        }
//        binding.progressBar.show()
        observeList()
//      dataViewModel.loadDataViewModel()
        dataViewModel.loadPhotoViewModel()

    }


    private fun observeList() {
//        observe(dataViewModel.dataList) {
//            when(it) {
//                is Resource.Success -> {
//                    Log.d("observeList123", "observeList123: "+it.data)
//
//                    it.data.let { dataList ->
//                        mAdapter.removeAll()
//                        mAdapter.addAll(dataList ?: emptyList())
//                    }
//
////                    mAdapter.removeAll()
////                    it.data.contents?.let {
////                        mAdapter.addAll(it)
////                        binding.emptyViewGroup.isVisible = it.isEmpty()
////                        binding.fixtureList.isVisible = it.isNotEmpty()
////                    } ?: binding.emptyViewGroup.show()
//                }
//                is Resource.Failure -> {
//                    Log.d("observeList", "observeList error: "+it.error.msg)
//                }
//            }
//        }

        observe(dataViewModel.photoList) {
            when(it) {
                is Resource.Success -> {
                    Log.d("observeList123", "observeList123: "+it.data)

                    it.data.let { photoList ->
                        mAdapter.removeAll()
                        mAdapter.addAll(photoList ?: emptyList())
                    }

//                    mAdapter.removeAll()
//                    it.data.contents?.let {
//                        mAdapter.addAll(it)
//                        binding.emptyViewGroup.isVisible = it.isEmpty()
//                        binding.fixtureList.isVisible = it.isNotEmpty()
//                    } ?: binding.emptyViewGroup.show()
                }
                is Resource.Failure -> {
                    Log.d("observeList", "observeList error: "+it.error.msg)
                }
            }
        }
    }
//    private fun observeList() {
//        observe(dataViewModel.dataList) {
//            when (it) {
//                is Resource.Success -> {
//
//                    Log.d("observeList123", "observeList123: "+it.data)
//                    dataViewModel.loadDataViewModel()
//                }
//                is Resource.Failure -> {
//                    if (it.error !is JobCanceledError) {
//                        Log.d("observeList", "observeList error: "+it.error.msg)
//                    }
//                }
//
//                else -> {
//                    Log.d("observeList", "not working")
//                }
//            }
//        }
//    }

    override fun onDestroyView() {
        binding.planList.adapter=null
        super.onDestroyView()
        _binding = null
    }

}