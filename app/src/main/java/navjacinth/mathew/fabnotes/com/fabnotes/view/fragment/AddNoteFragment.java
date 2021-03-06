package navjacinth.mathew.fabnotes.com.fabnotes.view.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import navjacinth.mathew.fabnotes.com.fabnotes.R;
import navjacinth.mathew.fabnotes.com.fabnotes.presenter.AddNotePresenter;
import navjacinth.mathew.fabnotes.com.fabnotes.view.activity.HomeActivity;
import navjacinth.mathew.fabnotes.com.fabnotes.view.interfaces.IAddNote;

public class AddNoteFragment extends Fragment implements IAddNote, View.OnClickListener {

    private EditText edtAddPost;
    private FloatingActionButton fabSave;
    private AddNotePresenter presenter;

    public AddNoteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_note, container, false);

        initialiseViews(view);
        setUpToolbar();

        return view;
    }

    @Override
    public void initialiseViews(View view) {
        edtAddPost = (EditText) view.findViewById(R.id.edt_add_note);
        ((HomeActivity)getActivity()).setFloatButtonImage(R.drawable.ic_save);

        getActivity().findViewById(R.id.fab_home).setOnClickListener(this);
    }

    @Override
    public void setUpToolbar() {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.txt_toolbar_title);
        toolbarTitle.setText("Add Note");
    }

    @Override
    public void initialisePresenter() {
        presenter = new AddNotePresenter(this, getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_home:
                Toast.makeText(getActivity(), "Save Note", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
