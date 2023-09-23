package com.jiteshtechguru.school.example.externalApiCall;

import java.util.ArrayList;

class Datum{
    public String name;
    public String capital;
    public String iso2;
    public String iso3;
}

class Root{
    public boolean error;
    public String msg;
    public ArrayList<Datum> data;
}