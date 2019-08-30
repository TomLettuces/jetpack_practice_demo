package com.tomlettuces.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    protected var mContext: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment_Lifecycle", "onAttach")
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Fragment_Lifecycle", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("Fragment_Lifecycle", "onCreateView")
        return if (initLayout() > 0) inflater.inflate(initLayout(), container, false) else super.onCreateView(
            inflater,
            container,
            savedInstanceState
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Fragment_Lifecycle", "onViewCreated")
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Fragment_Lifecycle", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Fragment_Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragment_Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragment_Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Fragment_Lifecycle", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Fragment_Lifecycle", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment_Lifecycle", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment_Lifecycle", "onDetach")
    }

    abstract fun initLayout(): Int

    abstract fun initView()
}