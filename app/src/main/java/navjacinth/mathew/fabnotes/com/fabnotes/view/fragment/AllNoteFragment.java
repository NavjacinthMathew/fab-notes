package navjacinth.mathew.fabnotes.com.fabnotes.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import navjacinth.mathew.fabnotes.com.fabnotes.R;
import navjacinth.mathew.fabnotes.com.fabnotes.adapter.NoteListAdapter;
import navjacinth.mathew.fabnotes.com.fabnotes.presenter.AllNotePresenter;
import navjacinth.mathew.fabnotes.com.fabnotes.view.interfaces.IAllNote;

public class AllNoteFragment extends Fragment implements View.OnClickListener, IAllNote {

    private RecyclerView recyclerAllNote;
    private Toolbar toolbar;
    private TextView txtToolbarTitle;
    private AllNotePresenter presenter;

    public AllNoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_note, container, false);

        initialiseViews(view);
        setUpToolbar(toolbar);
        initialisePresenter();

        return view;
    }

    @Override
    public void initialiseViews(View view) {
        recyclerAllNote = (RecyclerView) view.findViewById(R.id.recycler_all_note);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_all_note);
        getActivity().findViewById(R.id.fab_home).setOnClickListener(this);
    }

    @Override
    public void setUpToolbar(View toolbarView) {
        txtToolbarTitle = (TextView) toolbarView.findViewById(R.id.txt_toolbar_title);
        txtToolbarTitle.setText("All Notes");
    }

    @Override
    public void initialisePresenter() {
        presenter = new AllNotePresenter(this, getActivity());
        presenter.getAllNoteData();
    }

    @Override
    public void setAdapter(NoteListAdapter adapter) {
        /*generate grid with 2 items in each row*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        /*Set layout manager initialised before*/
        recyclerAllNote.setLayoutManager(layoutManager);

        /*Set adapter to the recycler view*/
        recyclerAllNote.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_home:
                Toast.makeText(getActivity(), "All Notes", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
