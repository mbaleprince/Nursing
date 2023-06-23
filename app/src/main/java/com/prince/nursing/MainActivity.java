package com.prince.nursing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView userRecycler;
    RecyclerviewAdapter recyclerviewAdapter;
    EditText searchView;
    CharSequence search="";
    FloatingActionButton options,share,report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(tool_bar);

        searchView = findViewById(R.id.search_bar);

        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(new UserData("Hand washing","This is a systematic process of cleaning the hands and arms using soap,water and friction to remove dirt.", " 1"));
        userDataList.add(new UserData("Protective wear","Using protective wear and removing after use.", " 2"));
        userDataList.add(new UserData("Sterilization","Use of steam,dry heat and chemical sterilization.", " 3"));
        userDataList.add(new UserData("Decontamination","Make instruments safer for handling.", " 4"));
        userDataList.add(new UserData("Barrier nursing","Isolation of infectious patients in single room to prevent cross infections.", " 5"));
        userDataList.add(new UserData("Waste management","Learn to put wastes in Back,yellow,red and brown bins.", " 6"));
        userDataList.add(new UserData("Cleaning of the ward","Cleaning of the ward daily,weekly.", " 7"));
        userDataList.add(new UserData("Bed making","Make various beds for comfortability of the patient.", " 8"));
        userDataList.add(new UserData("Positions used in nursing","The dorsal,semi-recumbent,supine/recumbent positions,lateral,prone,sitting up position etc.", " 9"));
        userDataList.add(new UserData("Lifting and turning patients","Lift patients using orthodox,australian methods and from trolley to bed and vice versa.", " 10"));
        userDataList.add(new UserData("Assessment of a client","Take history and analyse nursing demands of a client.", " 11"));
        userDataList.add(new UserData("Physical examination","Inspection,percussion and auscultaion.", " 12"));
        userDataList.add(new UserData("Admission,management,transfer and discharge","Patients are usually admitted in hospital because they are ill.", " 13"));
        userDataList.add(new UserData("Vital Observations","Learn to take temperature,pulse,blood pressure etc.", " 14"));
        userDataList.add(new UserData("Giving bed pan and urinals","Identify and prepare requirements for giving a bed pan or urinal."," 15"));
        userDataList.add(new UserData("Bed bath","The process of cleaning a patient while in bed."," 16"));
        userDataList.add(new UserData("Oral hygiene","Brushing and cleaning the oral cavity."," 17"));
        userDataList.add(new UserData("Care for hair","Washing and treating infested hair."," 18"));
        userDataList.add(new UserData("Care for the eye","Procedures to clean a patient's eye"," 19"));
        userDataList.add(new UserData("Instill eye drops/ointment","Instill eye drops/ointment in patient's eye."," 20"));
        userDataList.add(new UserData("Applying compress","Procedures to apply warm and cold compress."," 21"));
        userDataList.add(new UserData("Irrigation of the eye","Learn procedures to irrigate the eyes."," 22"));
        userDataList.add(new UserData("Care for the ears","Perform ear syringing procedure"," 23"));
        userDataList.add(new UserData("Pressure sores","Procedures to manage and prevent of pressure sores."," 24"));
        userDataList.add(new UserData("Management of rigor","An intense attack with shivering as a result of disturbance of heat regulating center of the brain."," 25"));
        userDataList.add(new UserData("Tepid sponging","Perform tepid sponging procedure."," 26"));
        userDataList.add(new UserData("Naso Gastric tube(NG tube)","Passing NG tube and feeding patients using NG tube."," 27"));
        userDataList.add(new UserData("Collection and exams of specimens","Collect and examine urine,stool and urine."," 28"));
        userDataList.add(new UserData("Test for gastric function","Do fractional meal test and histamine stimulation test."," 29"));
        userDataList.add(new UserData("Oral drug administration","Taking drugs by mouth"," 30"));
        userDataList.add(new UserData("Inhalation","Breathing in air,vapour containing medicine into lungs."," 31"));
        userDataList.add(new UserData("Parenteral Route(Injection)","Injection of drugs into veins or skeletal muscles."," 32"));
        userDataList.add(new UserData("Instill medication in ear and eye","Procedures to instill medications in the eyes and ears."," 33"));
        userDataList.add(new UserData("Administer nasal drops","Instilling medication into the nose."," 34"));
        userDataList.add(new UserData("Apply topical medication","Procedures to apply medications like creams on the skin."," 35"));
        userDataList.add(new UserData("Administer Rectal or vaginal medications","Put in suppositories and pessaries in the rectum or vagina."," 36"));
        userDataList.add(new UserData("Administer medicine through intravenous infusion","Administer medication through veins."," 37"));
        userDataList.add(new UserData("Blood transfusion","Intravenous replacement of lost or destroyed blood."," 38"));
        userDataList.add(new UserData("Monitoring fluid balance","Monitor fluid input and output using a fluid balance chart."," 39"));
        userDataList.add(new UserData("Pre operative care","Care for a client before surgical operations."," 40"));
        userDataList.add(new UserData("Post operative care","Procedures to care for a patient after a surgical operation."," 41"));
        userDataList.add(new UserData("Wound dressing","Proper care and dressing of a wound."," 42"));
        userDataList.add(new UserData("Removal of sutures or clips","Sutures are used to close wounds."," 43"));
        userDataList.add(new UserData("Shortening or removal of a drain","A surgical drain is a tube used to remove pus,blood or any other fluid from a wound."," 44"));
        userDataList.add(new UserData("Colostomy or stoma care","An opening in the abdominal wall to drain feaces."," 45"));
        userDataList.add(new UserData("Traction","A pull exerted on the part of the limb against a pull of compared strength in the opposite."," 46"));
        userDataList.add(new UserData("Bandaging","Learn procedures to bandage in the different styles."," 47"));
        userDataList.add(new UserData("Catheterization","Inserting a rubber,plastic or metallic tube into the urethra to keep it open or drain urine."," 48"));
        userDataList.add(new UserData("Bladder irrigation","Push in fluids into the bladder.", " 49"));
        userDataList.add(new UserData("Urine retention","Management of a patient with urine retention."," 50"));
        userDataList.add(new UserData("Administration of enemata","Introduce fluids into the lower bowel which causes the fluid to be returned with faeces."," 51"));
        userDataList.add(new UserData("Lavage","Learn about gastric lavage,rectal lavage (irrigation or wash out of a hollow organ)."," 52"));
        userDataList.add(new UserData("Vulva swabbing or toilet","Procedure to keep the vulva clean,dry and remove discharges"," 53"));
        userDataList.add(new UserData("Lumbar puncture","Insert a special needle into the sub-arachnoid space to remove cerebral spinal fluid."," 54"));
        userDataList.add(new UserData("Gastrostomy","Feeding a patient through an opening directly into the stomach through abdominal wall."," 55"));
        userDataList.add(new UserData("Tracheostomy","An opening into the trachea"," 56"));
        userDataList.add(new UserData("Paracentesis abdominis","Procedure to aspirate fluids from the peritoneal cavity."," 57"));
        userDataList.add(new UserData("Last office","Care for the dead."," 58"));
        //Midwifery starts here
        userDataList.add(new UserData("Carry out antenatal care","Identify requirements and carry out assessment of a pregnant mother in ANC.", " 59"));
        userDataList.add(new UserData("Physical examination","This is a systematic examination done from head to toe during antenatal visit.", " 60"));
        userDataList.add(new UserData("Admission of a mother in labour","Identify and prepare requirements for admission of a mother in labour.", " 61"));
        userDataList.add(new UserData("Vaginal examination in labour","Carry out vaginal examination on a mother in labour.", " 62"));
        userDataList.add(new UserData("Internal pelvic assessment","Identify and prepare requirements for performing internal pelvic assessment.", " 63"));
        userDataList.add(new UserData("Management of a mother in first stage of labour","This is the period from onset of true labour to full dilation of the cervix.", " 64"));
        userDataList.add(new UserData("Management of second stage of labour","Identify,prepare and conduct second stage of labour.", " 65"));
        userDataList.add(new UserData("Episiotomy","An incision made in the thinned out perineum to enlarge the vaginal outlet.", " 66"));
        userDataList.add(new UserData("Active management of third stage of labour","This is the process of separation,descent,expulsion of placenta and membranes.", " 67"));
        userDataList.add(new UserData("Placenta examination","Carryout examination of the placenta.", " 68"));
        userDataList.add(new UserData("Post partum care","This is service offered to a mother after delivery at 6hrs,6days,6weeks and 6months.", " 69"));
        userDataList.add(new UserData("Care of the perineum","Identify,prepare and perform perineal care after delivery", " 70"));
        userDataList.add(new UserData("Examination of a new born","Prepare and systematically perform examination of a new born.", " 71"));
        userDataList.add(new UserData("Daily cord care","Identify,prepare and perform care of the cord..", " 72"));
        userDataList.add(new UserData("Bathing the baby","Learn procedures to bath a baby after delivery."," 73"));
        userDataList.add(new UserData("Breast feeding","Assist the mother to carry out breast feeding."," 74"));
        userDataList.add(new UserData("Young child clinic","Carry out various activities in the young child clinic."," 75"));
        userDataList.add(new UserData("Immunization","This is stimulation of the body to produce antibodies after introduction of dead or weakened live vaccines."," 76"));
        userDataList.add(new UserData("Resuscitation","Identify,prepare and perform resuscitation of a new born baby."," 77"));
        userDataList.add(new UserData("Care for a sick new born baby","Provide care to a baby in a special care unit using various methods."," 78"));
        userDataList.add(new UserData("Care for a new born baby in the incubator","Learn procedures to provide care to a baby in an incubator."," 79"));
        userDataList.add(new UserData("Care for a baby undergoing phototherapy","Identify,prepare and care for the baby undergoing phototherapy."," 80"));
        userDataList.add(new UserData("Admission of a baby born before arrival","Procedures to care for a baby before arrival in a maternity unit."," 81"));
        userDataList.add(new UserData("Neonatal seizures","Identify,prepare and provide care to a baby with neonatal seizure."," 82"));
        userDataList.add(new UserData("Aminocentesis","This is withdrawal of liquor amni from the amniotic sac."," 83"));
        userDataList.add(new UserData("Multiple pregnancy","This term is used to describe the development of more than one foetus in the uterus at the sametime."," 84"));
        userDataList.add(new UserData("Ante Partum Haemorrhage (APH)","This is bleeding from or into the genital tract after 28th week of gestation up to the end of the first stage of labour."," 85"));
        userDataList.add(new UserData("Management of severe pre-eclampsia and eclampsia","Identify,prepare and manage a mother with pre-eclampsia and eclampsia."," 86"));
        userDataList.add(new UserData("Performing Manual Vacuum Aspiration (MVA)","Set up a trolley to perform manual vacuum aspiration procedure."," 87"));
        userDataList.add(new UserData("Induction of labour","This is initiation of contractions by artificial means in a pregnant mother who is not in labour."," 88"));
        userDataList.add(new UserData("Management of cord prolapse","This is when the the cord protrudes first instead of the baby's head."," 89"));
        userDataList.add(new UserData("Shoulder dystocia","This is the inability of the shoulders to be delivered spontaneously.."," 90"));
        userDataList.add(new UserData("Breech delivery","Occurs when the buttocks or feet of the foetus enters the maternal pelvis before the head."," 91"));
        userDataList.add(new UserData("Post Partum Haemorrhage (PPH)","Is the excessive bleeding from birth canal amounting to 500mls or more."," 92"));
        userDataList.add(new UserData("Post Operative Care following caesarean section","Care for a mother after caesarean section procedure."," 93"));
        userDataList.add(new UserData("Care of cracked nipple","Care for a mother with cracked nipple."," 94"));
        userDataList.add(new UserData("Management of engorged breasts","Identify,prepare requirements and carry out care for a mother with engorged breasts."," 95"));

        setUserRecycler(userDataList);


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                recyclerviewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        options = (FloatingActionButton) findViewById(R.id.add_fab);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
            }
        });
    }

    private  void  setUserRecycler(List<UserData> userDataList){
        userRecycler = findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(this, userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
    }
}