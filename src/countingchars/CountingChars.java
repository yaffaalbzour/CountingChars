/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingchars;
//هدول لايبراريز جاهزة بالجافا وحدة للبافر ريدر هسا بنحكي عنها تحت
//الي تحتها للفايل ريدر برضو بنحكي عنها بس نيجيلها
//الي تحتها للاكسيبشن 
//اخر واحد لسكانر مشان يقرا من المستخدم
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yaffa
 */
public class CountingChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path of the text file you want to read, please.");
//        استقبال اسم الملف من المسنخدم
        String file_name=in.nextLine(); 
//        استقبال الحرفمن المستخدم للبحث عنه فس الملف
        System.out.println("Enter a charecter to find out the number of its occurence, please.");
        String find=in.next();
//        اذا ادخل المستخدم اكثر من حرف يأخذ فقط الحرف الاول وبضعه في متغير فايندـ كار
        char find_char = find.charAt(0);
//        تعريف متغير تكست لتخزين محتوى الملف الذي ادخل اسمه المستخدم مسبقا
        String text=null;
//        جملة تراي كاتض 
//داخل التراي سوف يحاول فتح الملف وقراءنه من خلال الفايل ريدر وثم تخزينه في متغير بي آر من نوع بافر ريدر
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))){
//            تخزين محتويات بي آر في المتغير تيكست الذي عرفناه سابقا وكان من نوع سترينغ
//استخدمنا الميثود الجاهزة ريد لاين وهي ستقرا الملف وهو افتراضا مكون من فقرة واحد يعني اعتبرتو سطر اختصارا
            text = br.readLine();
//            يذهب للكاتش ويضهر اكسبشن اذا لم بفلح بفتح الملف مثلا بسبب ان اسمه غير موجود او انه غير قابل للقراءة
        }catch(IOException e){}
//        ضبط العداد لحساب الرن تايم
// هنا اخذنا الوقت الحالي بالنانو وخزناه في المتغير
        Long itr_start= System.nanoTime();
//        داخل جملة الطباعة استدعينا ميثود الابتبراتف مشان يطبع كلشي مرة وحدة
        System.out.println("The number of occurrenes of the input character \""+
                    find_char+"\" in the text file \""+file_name+"\" is: "+
                ItrCountingChar(text, find_char));
//        هنا بعد ما انتهى عمل الميثود قمنا باخذ الوقت الحالي بعد انتهاء عملية العد وخزناه ففي المتغير
        Long itr_stop = System.nanoTime();
//        لحساب الوقت المستغر او الرن تايمق قمنا بعملية الطرح
        Long itr_runtime = itr_stop-itr_start; // The runtime
//        هنا قمنا بطباعة الرن تايم
        System.out.println("The total runtime for the iterative algorithm is: "+itr_runtime);
//        هنا اخذما الوفت الحالي مشان نبقى نحسب للطريقة الثانية
        Long rec_start = System.nanoTime();
//        هنا نفس الاسلوب الاول طبعنا شوية حكي واستعينا الميثود الثانية الي هي الريكيرسف وبعثنا المتغيرات هسا بنحكي عنهن تحت
        System.out.println("The number of occurrenes of the input character \""+
                    find_char+"\" in the text file \""+file_name+"\" is: "+
                RecCountingChar(text, find_char, text.length()));
//        هنا اخذنا الوقت بعد ما خلصت الميثود الركيرسف وحسبنا الوقت المستغرق بنفس الطريقة السابقة وطبعناها
        Long rec_stop= System.nanoTime();
        Long rec_runtime = rec_stop - rec_start; // The runtime
        System.out.println("The total runtime for the iterative algorithm is: "+rec_runtime);
    }
//    هذه ميثود الريكيرسف
//    استقبلت النص الذي سنبحث به والحرف الذي سنبحث عنه وطول النص الاصلي
    public static int RecCountingChar(String text, char find_char, int text_len){
//        هنا فحصنا طول النص وهذه الجملة مهمة من اجل التوقف والعودة للمين مشان مبصيرش انفنت لوب ونعلق
//اذا اصبح طول النص اقل من واحد يرجع قيمة صفر
//هذه الجملة الجملة يتم استدعاءهااخر اشي يعني لما يخلص النص
        if(text_len<1) return 0;
//        اذا كان طول النص واحد فأكثر سيقوك بداية يتنقيص الطول
//عادة يبدأ ترقيم الاحرف من عند صفر هذا يعني ان رقم اخر حرف هو طول النص ناقص واحد
        text_len--;
//        بفحص النص حرف حرف 
//اذا كان الحرف الحالي بساوي الحرف الذي نريده
//بداية سوف يفحص اخر حرف بالنص والذي رقمة  طول النص ناقص واحد
        if(text.charAt(text_len)==find_char){
//            سوف يزيد واحد ويرسل النص والحرف وطول النص الي عدلنا فوق ونقصنا منه واحد 
            return 1+RecCountingChar(text, find_char, text_len);
        }else{
//            هون اذا لم يكن الحرف الحالي مساوي للحرف الذي نبحث عنه يضيف صفر ويرسل المعلومات بنفس الطريقة اعلاه
            return 0 + RecCountingChar(text, find_char, text_len);
        }
    }
//    هذه الميثود الايتيريتف
//    تيتقبل هذه الميثود النص الذي سنبحث فيه والحرف الذي سنبحث عنه
    public static int ItrCountingChar(String text, char find_char){
//        هذا المتغير هو العدار سوف يزيد بمقدار واحد اذا وجدنا الحرف 
        int char_count = 0;
//        بداية الفور لوب الذي سيتوقف عندما مصل لاخر حرف بالمص
            for(int i =0; i<text.length()-1; i++){
//                هنا داخل جملة الاف يفحص النص حرف حرف من اول حرف وحتى اخر حرف 
//اذا كان الحرف الحاي يساوب الحرف الذي نبحث عنه يعني ترو
                if(text.charAt(i)==find_char){
//                    يدخل الى الجملة هذه والتي تزيد العداد
                    char_count ++;
                }
//                اذا لم بكن الحرف الحالي بالنص مساويا للحرف الذي نبحث عنه لن يفعل شي أي لن يزيد العداد كارـ كاونت
            }
//            بنهاية الفور لوب وعند الوصول لاخر حرف يقوم بارجاع العدار كارـ كاونت
            return char_count;
        
    }
}
//وخلصنا لولولولولولولولولولولولولولولولوليييييييييش
//انشالله يكون شرحي بفهم يا بعدي لان اذا مفهمتيش دنتحر تهمنا راحتكم نعمل لاجلكم