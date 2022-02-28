package pl.com.kamil.widgetprobakolejna;
import androidx.lifecycle.ViewModel;

class MainActivityViewModel extends ViewModel {
    String text = "";

    void setText() {
        String text = textNote.getText();
    }
}

