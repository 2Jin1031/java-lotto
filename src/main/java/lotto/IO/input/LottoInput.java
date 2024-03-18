//package lotto.IO.input;
//
//import lotto.IO.info.Info;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static java.util.Arrays.stream;
//
//public class Lottos {
//
//    private final Info info;
//    private final List<Integer> lottes;
//    //private final InputConfig inputConfig;
//
//    public Lottos(List<Integer> lottes/*Info info*//*, InputConfig inputConfig*/) {
//        this.info = new Info();
//        Info();
//        //this.inputConfig = inputConfig;
//        this.lottes = lottes;
//    }
//
//    private List<Integer> getInput() {
//        final List<Integer> lottes;
//        Info();
//        String str = null;
//        try{
//            str = InputConfig.Input();
//        } catch (Exception e) {
//            System.out.println(str);
//            throw new IllegalArgumentException("입력 처리 중 예외 발생", e);
//        }
//        String[] num = str.split(",");
//        List<Integer> inputNumbers = stream(num)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        lottes = new ArrayList<>(inputNumbers);
//        return lottes;
//    }
//
//
//    public void Info() {
//        info.LottoTicket();
//    }
//
//    public List<Integer> getLottes() {
//        return lottes;
//    }
//}
