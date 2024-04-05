package kz.android.lab2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.android.lab2.databinding.ItemCatBinding
import kz.android.lab2.model.CatBreed

class CatAdapter : ListAdapter<CatBreed, CatAdapter.CatViewHolder>(CatBreedDiffCallback) {


    object CatBreedDiffCallback : DiffUtil.ItemCallback<CatBreed>() {
        override fun areItemsTheSame(oldItem: CatBreed, newItem: CatBreed): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CatBreed, newItem: CatBreed): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCatBinding.inflate(layoutInflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val CatBreed = getItem(position)
        holder.bind(CatBreed)
    }

    class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(CatBreed: CatBreed) {
            with(binding) {
                tvCatName.text = CatBreed.name
                tvGoodWithChildren.text = "intelligence: ${CatBreed.goodWithChildren}"
                tvGoodWithOtherDogs.text = "grooming: ${CatBreed.goodWithOtherDogs}"
                tvEnergy.text = "other_pets_friendly: ${CatBreed.energy}"
                tvLifeExpectancy.text = "Life Expectancy: ${CatBreed.minLifeExpectancy}-${CatBreed.maxLifeExpectancy} years"

                Glide.with(ivDogImage.context)
                    .load(CatBreed.imageLink)
                    .into(ivDogImage)
            }
        }
    }
}
