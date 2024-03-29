package com.example.gallerydemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallerydemo.Activity.FolderDataActivity;
import com.example.gallerydemo.Adapter.FolderListAdapter;
import com.example.gallerydemo.R;
import com.example.gallerydemo.Utils.MyUtil;

public class FolderFragment extends Fragment {

    RecyclerView allfolderRV;
    FolderListAdapter folderListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_folder, container, false);

        allfolderRV = view.findViewById(R.id.allfolderRV);

        folderListAdapter = new FolderListAdapter(MyUtil.getImageFolder(requireActivity()), requireContext(), new FolderListAdapter.Click() {
            @Override
            public void ClickToActivity(String string) {
                Intent intent = new Intent(requireActivity(), FolderDataActivity.class);
                intent.putExtra("mealID", string);
                startActivity(intent);
            }
        });

        allfolderRV.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        allfolderRV.setAdapter(folderListAdapter);

        return view;
    }
}