Color .java 
package com.example.ex4_color; 
import android.os.Bundle; 
import android.app.Activity; 
import android.graphics.Color; 
import android.view.Menu; 
import android.view.MenuItem; 
import android.view.View; 
import android.widget.TextView; 
public class Colormenu extends Activity { 
View ob; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_colormenu); 
ob = (View) findViewById(R.id.mainlayout);} 
@Override  
public boolean onCreateOptionsMenu(Menu menu) { 
// Inflate the menu; this adds items to the action bar if it is present. 
getMenuInflater().inflate(R.menu.colormenu, menu); 
return true;} 
public boolean onOptionsItemSelected(MenuItem a){ 
int id = a.getItemId(); 
if (a.getTitle().toString().equals("Red")) 
ob.setBackgroundColor(Color.RED);  
else if(a.getTitle().toString().equals("Green")) 
ob.setBackgroundColor(Color.GREEN); 
else if(a.getTitle().toString().equals("Blue")) 
ob.setBackgroundColor(Color.BLUE); 
else if(a.getTitle().toString().equals("Cyan")) 
ob.setBackgroundColor(Color.CYAN); 
else if(a.getTitle().toString().equals("Gray")) 
ob.setBackgroundColor(Color.GRAY); 
else if (a.getTitle().toString().equals("Black")) 
ob.setBackgroundColor(Color.BLACK); 
else if(a.getTitle().toString().equals("White")) 
ob.setBackgroundColor(Color.WHITE); 
return super.onOptionsItemSelected(a);  } }  
Text.java 
package com.textmani;  
import android.app.Activity; 
import android.graphics.Typeface; 
import android.os.Bundle; 
import android.text.SpannableString; 
import android.text.style.StyleSpan; 
import android.text.style.UnderlineSpan; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.EditText; 
import android.widget.TextView; 
publicclass TextmaniActivity extends Activity { 
TextView t1,t2,t3; 
EditText et; 
@Override 
publicvoid onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.main); 
t1=(TextView)findViewById(R.id.textView1); 
t2=(TextView)findViewById(R.id.textView2); 
t3=(TextView)findViewById(R.id.textView3); 
et=(EditText)findViewById(R.id.editText1); 
handleclick hc=new handleclick(); 
findViewById(R.id.button1).setOnClickListener(hc); 
findViewById(R.id.button2).setOnClickListener(hc); 
findViewById(R.id.button3).setOnClickListener(hc);  } 
privateclass handleclick implements OnClickListener{ 
publicvoid onClick(View args0){ 
if(args0.getId()==R.id.button1){ 
String samp = et.getText().toString(); 
SpannableString spanString=new SpannableString(samp); 
spanString.setSpan(new UnderlineSpan(),0,spanString.length(),0) ; 
t1.setText(spanString); } 
if(args0.getId()==R.id.button2){ 
String samp = et.getText().toString(); 
SpannableString spanString=new SpannableString(samp); 
spanString.setSpan(new StyleSpan(Typeface.BOLD),0,spanString.length(),0) ; 
t2.setText(spanString); } 
if(args0.getId()==R.id.button3){ 
String samp = et.getText().toString(); 
SpannableString spanString=new SpannableString(samp); 
spanString.setSpan(new StyleSpan(Typeface.ITALIC),0,spanString.length(),0) ; 
t3.setText(spanString); }}}} 
Image manipulation animate.java 
package com.example.aninmatebitmap; 
import android.content.Context; 
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory; 
import android.graphics.Canvas; 
import android.graphics.Color; 
import android.graphics.Paint; 
import android.graphics.Rect; 
import android.view.View;  
public class animate extends View{ 
Bitmap bm; 
int x,y; 
public animate(Context context) 
{super(context); 
bm=BitmapFactory.decodeResource(getResources(), R.drawable.image4); 
x = 0; y = 0;} 
@Override 
protected void onDraw(Canvas canvas) { 
// TODO Auto-generated method stub 
super.onDraw(canvas); 
Rect myrect = new Rect(0, 0, canvas.getWidth(),canvas.getHeight()/2); 
Paint pa = new Paint(); 
pa.setColor(Color.MAGENTA); 
pa.setStyle(Paint.Style.STROKE); 
canvas.drawRect(myrect, pa); 
if (x < canvas.getWidth()) 
{x += 10;} 
else 
{x = 0;} 
if (y < canvas.getHeight()) 
{y += 10;} 
else 
{y = 0;} 
canvas.drawBitmap(bm, x, y, new Paint()); 
invalidate();}} 
mainactivity.java 
package com.example.aninmatebitmap; 
import android.os.Bundle; 
import android.app.Activity; 
import android.view.Menu; 
public class MainActivity extends Activity { 
animate var; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
var=new animate(this); 
setContentView(var); } 
@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
// Inflate the menu; this adds items to the action bar if it is present. 
getMenuInflater().inflate(R.menu.main, menu); 
return true; } } 
Implicit Intents.java 
package com.intent;  
import android.app.Activity; 
import android.os.Bundle; 
import android.content.Intent; 
import android.net.Uri; 
import android.os.Bundle; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.EditText; 
publicclass IntentActivity extends Activity { 
@Override 
publicvoid onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.main); 
final EditText editText1=(EditText)findViewById(R.id.editText1); 
Button button1=(Button)findViewById(R.id.button1); 
button1.setOnClickListener(new View.OnClickListener() { 
publicvoid onClick(View arg0) { 
String Url=editText1.getText().toString(); 
Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(Url)); 
startActivity(intent);  } 
}); 
} 
} 
Explicit intent.java 
package com.explicit; 
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
public class Explicit1Activity extends Activity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.main); 
Button button = (Button) findViewById(R.id.button1); 
button.setOnClickListener(new View.OnClickListener() { 
public void onClick(View v)  
Intent intent = new Intent(Explicit1Activity.this, secondactivity.class); 
startActivity(intent); 
} 
});}} 
Activity 2.java 
package com.explicit; 
import android.app.Activity; 
import android.os.Bundle; 
import android.widget.TextView; 
public class secondactivity extends Activity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.second); 
}} 
Radio.java 
package com.example.animationexample; 
import android.os.Bundle; 
import android.app.Activity; 
import android.view.Menu; 
import android.widget.ImageView; 
import android.widget.RadioButton; 
import android.widget.RadioGroup; 
public class MainActivity extends Activity{ 
RadioGroup rad1; 
ImageView Image1; 
Integer []photos = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
Image1 = (ImageView)findViewById(R.id.imageView1); 
rad1 = (RadioGroup)findViewById(R.id.radioGroup1); 
rad1.setOnCheckedChangeListener(new 
RadioGroup.OnCheckedChangeListener() { 
@Override 
public void onCheckedChanged(RadioGroup rad1, int i) { 
// TODO Auto-generated method stub 
RadioButton radio = (RadioButton) rad1.findViewById(i); 
int index1 = rad1.indexOfChild(radio); 
Image1.setImageResource(photos[index1]); 
}});} 
@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
getMenuInflater().inflate(R.menu.main, menu); 
return true; 
}} 
 
 
 
 