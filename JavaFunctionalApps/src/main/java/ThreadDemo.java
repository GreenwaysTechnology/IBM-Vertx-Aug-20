import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ThreadDemo {
    public static void main(String[] args) {
        Observable.range(1, 100000)
                .toFlowable(BackpressureStrategy.DROP)
                .subscribe(System.out::println);



    }
}
