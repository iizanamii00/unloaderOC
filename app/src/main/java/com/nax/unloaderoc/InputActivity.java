package com.nax.unloaderoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.nax.unloaderoc.models.CPU;
import com.nax.unloaderoc.models.Case;
import com.nax.unloaderoc.models.GPU;
import com.nax.unloaderoc.models.HDD;
import com.nax.unloaderoc.models.MotherBoard;
import com.nax.unloaderoc.models.PSU;
import com.nax.unloaderoc.models.RAM;
import com.nax.unloaderoc.models.SSD;

public class InputActivity extends AppCompatActivity {

    public CPU cpus[] = new CPU[22];
    public Case cases[] = new Case[18];
    public GPU gpus[] = new GPU[20];
    public HDD hdds[] = new HDD[5];
    public MotherBoard motherBoards[] = new MotherBoard[22];
    public PSU psus[] = new PSU[10];
    public RAM rams[] = new RAM[13];
    public SSD ssds[] = new SSD[8];

    private Spinner usecase, platform, budget;
    private Button submit;

    String Use, Plat, Budget;
    double cpuBudget, gpuBudget, moboBudget, ramBudget, caseBudget, psuBudget, ssdBudget, hddBudget;
    double cpuPrice, gpuPrice, moboPrice, ramPrice, casePrice, psuPrice, ssdPrice, hddPrice;
    int cpuPos, gpuPos, moboPos, ramPos, casePos, psuPos, ssdPos, hddPos;
    double totalTDP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        loadParts();

        usecase = findViewById(R.id.usecase_spinner);
        platform = findViewById(R.id.platform_spinner);
        budget = findViewById(R.id.budget_spinner);
        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Use = usecase.getSelectedItem().toString();
                Plat = platform.getSelectedItem().toString();
                Budget = budget.getSelectedItem().toString();
                calculateParts();
            }
        });
    }

    public void loadParts() {
        cpus[0] = new CPU("AMD Athlon 3000g","AM4", 5000, 65);
        cpus[1] = new CPU("Intel Pentium g6600","LGA 1151", 6000, 65);
        cpus[2] = new CPU("Intel core i3 10100", "LGA 1151", 9000, 65);
        cpus[3] = new CPU("Intel core i3 11100", "LGA 1200", 10000, 65);
        cpus[4] = new CPU("Intel core i5 10400","LGA 1151", 11000, 65);
        cpus[5] = new CPU("AMD Ryzen 3 3300", "AM4", 11001, 65);
        cpus[6] = new CPU("Intel core i5 11400", "LGA 1200", 14000, 65);
        cpus[7] = new CPU("AMD Ryzen 5 3500", "AM4", 15000, 65);
        cpus[8] = new CPU("Intel core i7 10700", "LGA 1200", 17500, 65);
        cpus[9] = new CPU("AMD Ryzen 5 3600", "AM4", 20000, 65);
        cpus[10] = new CPU("Intel core i5 10600k", "LGA 1151", 20100, 125);
        cpus[11] = new CPU("Intel core i5 11600K", "LGA 1200", 22000, 125);
        cpus[12] = new CPU("AMD Ryzen 7 3700", "AM4", 23000, 65);
        cpus[13] = new CPU("Intel core i7 10700k", "LGA 1151", 24000, 150);
        cpus[14] = new CPU("Intel core i7 11700k", "LGA 1200", 28000, 125);
        cpus[15] = new CPU("AMD Ryzen 5 5600", "AM4", 28001, 65);
        cpus[16] = new CPU("AMD Ryzen 7 3800x", "AM4", 29000, 120);
        cpus[17] = new CPU("AMD Ryzen 7 5800", "AM4", 33000, 105);
        cpus[18] = new CPU("AMD Ryzen 9 3900", "AM4", 35000, 120);
        cpus[19] = new CPU("Intel core i9 10900k", "LGA 1151", 35500, 250);
        cpus[20] = new CPU("Intel core i9 11900k", "LGA 1200", 38000, 250);
        cpus[21] = new CPU("AMD Ryzen 9 5900", "AM4", 42000, 125);

        cases[0] = new Case("Aerocool Bolt", "matx", 2400);
        cases[1] = new Case("Cooelr master elite 310", "matx", 3200);
        cases[2] = new Case("Deepcool Macube 310", "matx", 3400);
        cases[3] = new Case("Silverstone fara r1", "matx", 3450);
        cases[4] = new Case("Cooler Master q300l", "matx", 4000);
        cases[5] = new Case("NZXT h210", "itx", 4400);
        cases[6] = new Case("Chiptronix Viper", "atx", 4700);
        cases[7] = new Case("Cooler master mb311L", "matx", 5500);
        cases[8] = new Case("Lian Li lancool 205", "atx", 5900);
        cases[9] = new Case("Deepcool matrexx 50", "atx", 5950);
        cases[10] = new Case("Corsair 220t", "atx", 6100);
        cases[11] = new Case("Cooler Master masterbox 5", "atx", 6400);
        cases[12] = new Case("NZXT h510", "matx", 6450);
        cases[13] = new Case("MSI mag shield", "ATX", 6800);
        cases[14] = new Case("Corsair 4000D", "atx", 8100);
        cases[15] = new Case("NZXT h710", "atx", 9400);
        cases[16] = new Case("Lian LI O11 Dynamic", "eatx", 10500);
        cases[17] = new Case("Cooler Master Cosmos 700", "eatx", 20000);

        gpus[0] = new GPU("Nill", 0, 0);
        gpus[1] = new GPU("GTX 1050Ti", 15000, 75);
        gpus[2] = new GPU("RX 5500", 17321, 120);
        gpus[3] = new GPU("GTX 1060", 21000, 120);
        gpus[4] = new GPU("GTX 1660", 23321, 120);
        gpus[5] = new GPU("GTX 1660 Super", 24000, 120);
        gpus[6] = new GPU("GTX 1660Ti", 24321, 120);
        gpus[7] = new GPU("RX 5600", 27321, 120);
        gpus[8] = new GPU("RTX 2060", 27521, 120);
        gpus[9] = new GPU("RX 5600 XT", 31321, 120);
        gpus[10] = new GPU("RTX 2070", 36321, 150);
        gpus[11] = new GPU("RX 5700", 40000, 150);
        gpus[12] = new GPU("RTX 3060", 45000, 120);
        gpus[13] = new GPU("RTX 2070 Super", 46500, 180);
        gpus[14] = new GPU("RTX 2080", 51000, 200);
        gpus[15] = new GPU("RX 5700 XT", 53321, 170);
        gpus[16] = new GPU("RTX 2080 Super", 61000, 200);
        gpus[17] = new GPU("RTX 3070", 69000, 220);
        gpus[18] = new GPU("RTX 3080", 75000, 250);
        gpus[19] = new GPU("RTX 3080Ti", 90000, 300);

        hdds[0] = new HDD("Segate Baracuda 320", 320, 1600);
        hdds[1] = new HDD("Seagate Barracuda 500", 500, 2250);
        hdds[2] = new HDD("Seagate Barracuda 1000", 1000, 3213);
        hdds[3] = new HDD("WD Blue", 1000, 3350);
        hdds[4] = new HDD("WD Black", 1000, 4500);


        motherBoards[0] = new MotherBoard("MSI h410", "LGA 1151", "atx", 4200);
        motherBoards[1] = new MotherBoard("MSI a320 pro vdh", "AM4", "matx", 5200);
        motherBoards[2] = new MotherBoard("msi h510-vs", "LGA 2000", "matx", 5201);
        motherBoards[3] = new MotherBoard("MSI h310-e", "LGA 1151", "matx", 6200);
        motherBoards[4] = new MotherBoard("Asrock b450m Steel legend", "AM4", "matx", 7820);
        motherBoards[5] = new MotherBoard("Gigabyte b450m gaming", "AM4", "matx", 8600);
        motherBoards[6] = new MotherBoard("Asrock b450 steel legend", "AM4", "atx", 9900);
        motherBoards[7] = new MotherBoard("Asus ROG Strix-E b450", "AM4", "atx", 10500);
        motherBoards[8] = new MotherBoard("Asus prime b450", "AM4", "atx", 11000);
        motherBoards[9] = new MotherBoard("Gigabyte b450 aorus elite", "AM4", "atx", 11200);
        motherBoards[10] = new MotherBoard("Asus Prime b460", "LGA 1151", "eatx", 11900);
        motherBoards[11] = new MotherBoard("MSI b450m Mortar", "AM4", "matx", 12000);
        motherBoards[12] = new MotherBoard("MSI b450 Tomahawk", "AM4", "atx", 12500);
        motherBoards[13] = new MotherBoard("Gigabyte b360", "LGA 1151", "atx", 13020);
        motherBoards[14] = new MotherBoard("ASus ROG Strif-F b450", "AM4", "atx", 13200);
        motherBoards[15] = new MotherBoard("MSI b560m Bazooka", "LGA 2000", "matx", 14200);
        motherBoards[16] = new MotherBoard("Asrock b560 steel legend", "LGA 2000", "atx", 14560);
        motherBoards[17] = new MotherBoard("Gigabye z490", "LGA 1151", "atx", 19600);
        motherBoards[18] = new MotherBoard("asus prime z590", "LGA 2000", "atx", 23000);
        motherBoards[19] = new MotherBoard("MSI x570 Godlike", "AM4", "eatx", 34000);
        motherBoards[20] = new MotherBoard("Asrock x570 Aqua", "AM4", "ematx", 36000);
        motherBoards[21] = new MotherBoard("MSI x570 Creator", "AM4", "eatx", 37000);

        psus[0] = new PSU("Zebronics Zeb450", 450, 2000);
        psus[2] = new PSU("Cooler Master Masterwatt 450", 450, 3500);
        psus[4] = new PSU("Cooler Master Masterwatt 550", 550, 5500);
        psus[5] = new PSU("Cooler Master Masterwatt 650", 650, 6500);
        psus[8] = new PSU("Corsair RM1000x",1000, 11000);
        psus[6] = new PSU("Corsair RM750", 750, 7200);
        psus[3] = new PSU("Corsair cx450", 450, 3600);
        psus[7] = new PSU("Corsair cx 750", 550, 7400);
        psus[1] = new PSU("Atom b550", 550, 3000);
        psus[9] = new PSU("Asus ROG Thor", 1200, 15000);

        rams[0] = new RAM("Generic", 8, 2333, 2700);
        rams[1] = new RAM("Adata Spectrix d40", 8, 3000, 3213);
        rams[2] = new RAM("Corsair LPX", 8, 3200, 4000);
        rams[3] = new RAM("Crucial Ballistix", 8, 3200, 4100);
        rams[4] = new RAM("Gskill Trident Z", 8, 3600, 4700);
        rams[5] = new RAM("Gskill Trident Z Royale", 8, 3600, 5100);
        rams[6] = new RAM("Corsair LPX", 16, 3200, 7600);
        rams[7] = new RAM("Adata Spectrix d40", 16, 3000, 7810);
        rams[8] = new RAM("Crucial Ballistix", 16, 3200, 8500);
        rams[9] = new RAM("Gskill Trident Z", 16, 3600, 10000);
        rams[10] = new RAM("Corsair Dominator Platinum RGB", 16, 3600, 12000);
        rams[11] = new RAM("Gskill Trident Z Royale", 32, 3600, 24000);
        rams[12] = new RAM("Corsair Dominator Platinum", 64, 4000, 48131);

        ssds[0] = new SSD("Crucial MX120", 120, 1900);
        ssds[1] = new SSD("WD Blue 1203d ", 120, 2100);
        ssds[2] = new SSD("Adata swordfish", 240, 3100);
        ssds[3] = new SSD("Crucial BX250", 250, 3400);
        ssds[4] = new SSD("Adata Falcon", 512, 4100);
        ssds[5] = new SSD("Adata Spectrix RGB", 580, 6150);
        ssds[6] = new SSD("Intel 660p", 1000, 7800);
        ssds[7] = new SSD("Corsair Force MP600", 500, 10000);

    }

    public void calculateParts() {
        cpuPrice = cpus[0].getPrice();
        gpuPrice = gpus[0].getPrice();
        moboPrice = motherBoards[0].getPrice();
        ramPrice = rams[0].getPrice();
        casePrice = cases[0].getPrice();
        psuPrice = psus[0].getPrice();
        ssdPrice = ssds[0].getPrice();
        hddPrice = hdds[0].getPrice();

        cpuPos = 0;
        gpuPos = 0;
        moboPos = 0;
        ramPos = 0;
        casePos = 0;
        psuPos = 0;
        ssdPos = 0;
        hddPos = 0;
        if (Budget.equals("30000")) {
            Plat = "Intel";
            cpuBudget = 30000*0.3;
            gpuBudget = 0;
            moboBudget = 30000*0.2;
            ramBudget = 30000*0.1;
            caseBudget = 30000*0.1;
            psuBudget = 30000*0.1;
            ssdBudget = 30000*0.1;
            hddBudget = 30000*0.1;
        } else if (Use.equalsIgnoreCase("Gaming")) {
            double bud = Integer.parseInt(Budget);
            cpuBudget = bud*0.2;
            gpuBudget = bud*0.4;
            moboBudget = bud*0.1;
            ramBudget = bud*0.05;
            caseBudget = bud*0.1;
            psuBudget = bud*0.05;
            ssdBudget = bud*0.05;
            hddBudget = bud*0.05;
        } else if (Use.equalsIgnoreCase("Video/Photo editing")) {
            double bud = Integer.parseInt(Budget);
            cpuBudget = bud*0.4;
            gpuBudget = bud*0.2;
            moboBudget = bud*0.1;
            ramBudget = bud*0.05;
            caseBudget = bud*0.1;
            psuBudget = bud*0.05;
            ssdBudget = bud*0.05;
            hddBudget = bud*0.05;
        } else if (Use.equalsIgnoreCase("Multimedia Consumption")) {
            double bud = Integer.parseInt(Budget);
            cpuBudget = bud*0.2;
            gpuBudget = bud*0.2;
            moboBudget = bud*0.1;
            ramBudget = bud*0.15;
            caseBudget = bud*0.15;
            psuBudget = bud*0.05;
            ssdBudget = bud*0.1;
            hddBudget = bud*0.05;
        } else if (Use.equalsIgnoreCase("Office Work")) {
            double bud = Integer.parseInt(Budget);
            cpuBudget = bud*0.3;
            gpuBudget = bud*0.1;
            moboBudget = bud*0.1;
            ramBudget = bud*0.15;
            caseBudget = bud*0.1;
            psuBudget = bud*0.05;
            ssdBudget = bud*0.15;
            hddBudget = bud*0.05;
        }

        for (int i = 0; i < cpus.length; i++) {
            if (cpus[i].getPrice() <= cpuBudget && cpus[i].getPrice() > cpuPrice) {
                cpuPrice = cpus[i].getPrice();
                cpuPos = i;
            }
        }
        for (int i = 0; i < gpus.length; i++) {
            if (gpus[i].getPrice() <= gpuBudget && gpus[i].getPrice() > gpuPrice) {
                gpuPrice = gpus[i].getPrice();
                gpuPos = i;
            }
        }
        for (int i = 0; i < motherBoards.length; i++) {
            if (motherBoards[i].getPrice() <= moboBudget && motherBoards[i].getPrice() > moboPrice && motherBoards[i].getSocket().equals(cpus[cpuPos].getSocket())) {
                moboPrice = motherBoards[i].getPrice();
                moboPos = i;
            }
        }
        for (int i = 0; i < rams.length; i++) {
            if (rams[i].getPrice() <= ramBudget && rams[i].getPrice() > ramPrice) {
                ramPrice = rams[i].getPrice();
                ramPos = i;
            }
        }
        for (int i = 0; i < cases.length; i++) {
            if (cases[i].getPrice() <= caseBudget && cases[i].getPrice() > casePrice && cases[i].getFormFactor().equals(motherBoards[moboPos].getFormFactor())) {
                casePrice = cases[i].getPrice();
                casePos = i;
            }
        }
        for (int i = 0; i < hdds.length; i++) {
            if (hdds[i].getPrice() <= hddBudget && hdds[i].getPrice() > hddPrice) {
                hddPrice = hdds[i].getPrice();
                hddPos = i;
            }
        }
        for (int i = 0; i < ssds.length; i++) {
            if (ssds[i].getPrice() <= ssdBudget && ssds[i].getPrice() > ssdPrice) {
                ssdPrice = ssds[i].getPrice();
                ssdPos = i;
            }
        }

        totalTDP = cpus[cpuPos].getTDP() + gpus[gpuPos].getTDP() + 150;

        for (int i = 0; i < psus.length; i++) {
            if (psus[i].getPrice() <= psuBudget && psus[i].getPrice() > psuPrice && psus[i].getWattage() >= totalTDP) {
                psuPrice = psus[i].getPrice();
                psuPos = i;
            }
        }

        Log.d("selected CPU", "" + cpus[cpuPos].getName());
        Log.d("selected GPU", "" + gpus[gpuPos].getName());
        Log.d("selected Mobo", "" + motherBoards[moboPos].getName());
        Log.d("selected PSU", "" + psus[psuPos].getName());
        Log.d("selected RAM", "" + rams[ramPos].getName());
        Log.d("selected ssd", "" + ssds[ssdPos].getName());
        Log.d("selected hdd", "" + hdds[hddPos].getName());
        Log.d("selected case", "" + cases[casePos].getName());

        Intent intent = new Intent(InputActivity.this, ResultActivity.class);
        intent.putExtra("CPU", cpus[cpuPos].getName());
        intent.putExtra("CPU Price", cpus[cpuPos].getPrice());
        intent.putExtra("GPU", gpus[gpuPos].getName());
        intent.putExtra("GPU Price", gpus[gpuPos].getPrice());
        intent.putExtra("Mobo", motherBoards[moboPos].getName());
        intent.putExtra("Mobo Price", motherBoards[moboPos].getPrice());
        intent.putExtra("PSU", psus[psuPos].getName());
        intent.putExtra("PSU Price", psus[psuPos].getPrice());
        intent.putExtra("RAM", rams[ramPos].getName());
        intent.putExtra("RAM Price", rams[ramPos].getPrice());
        intent.putExtra("SSD", ssds[ssdPos].getName());
        intent.putExtra("SSD Price", ssds[ssdPos].getPrice());
        intent.putExtra("HDD", hdds[hddPos].getName());
        intent.putExtra("HDD Price", hdds[hddPos].getPrice());
        intent.putExtra("Case", cases[casePos].getName());
        intent.putExtra("Case Price", cases[casePos].getPrice());
        startActivity(intent);
    }
}