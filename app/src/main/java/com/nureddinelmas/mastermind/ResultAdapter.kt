package com.nureddinelmas.mastermind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nureddinelmas.localizition.databinding.RecyclerRowBinding

class ResultAdapter(private val imageLook: ArrayList<ResultLook>) : RecyclerView.Adapter<ResultAdapter.ResultHolder>() {
    class ResultHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
       val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ResultHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        holder.binding.p1.setImageResource(imageLook[position].first)
        holder.binding.p2.setImageResource(imageLook[position].second)
        holder.binding.p3.setImageResource(imageLook[position].third)
        holder.binding.p4.setImageResource(imageLook[position].fourth)
        holder.binding.wrongPlaceText.text = imageLook[position].lookWrong
        holder.binding.rightPlaceText.text= imageLook[position].lookRight
    }

    override fun getItemCount(): Int {
       return imageLook.size
    }
}