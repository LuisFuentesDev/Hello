package com.example.hello;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hello.databinding.FragmentNameBinding;
import com.example.hello.databinding.FragmentTriviaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TriviaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TriviaFragment extends Fragment {

    private FragmentTriviaBinding binding;

    private int checkedId;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TriviaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TriviaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TriviaFragment newInstance(String param1, String param2) {
        TriviaFragment fragment = new TriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTriviaBinding.inflate(getLayoutInflater(), container, false);

        binding.textViewHello.setText("Hola, " + mParam1);


        binding.buttonSend.setOnClickListener(view -> {

            if (binding.radioPokemon.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getContext(), "Selecciona una opción", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.radioPokemon.getCheckedRadioButtonId() == binding.radioButton5.getId()) {
                Bundle bundle = new Bundle();
                bundle.putString("respuesta", "Correcto");
                bundle.putString("nombre", mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_triviaFragment_to_resultFragment, bundle);


            } else {
                Bundle bundle = new Bundle();
                bundle.putString("respuesta", "Incorrecto");
                bundle.putString("nombre", mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_triviaFragment_to_resultFragment, bundle);
            }

        });

        return binding.getRoot();
    }
}