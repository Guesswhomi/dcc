// Online C++ compiler to run C++ program online
#include<bits/stdc++.h> 
using namespace std;

int main() {
    int ns,ncs,timestamp,site;
    cout<<"enter number of sites ";
    cin>>ns;
    cout<<"\nenter who enters critical section ";
    cin>>ncs;
    vector<int>ts(ns,0);
    vector<int>request;
    map<int,int>mp;
    
    for(int i=0;i<ncs;i++){
        cout<<"\nenter timestamps ";
        cin>>timestamp;
        cout<<"\nenter site number ";
        cin>>site;
        ts[site-1]=timestamp;
        request.push_back(site);
        mp[timestamp]=site;
    }
    
    cout<<"\nsite and timestamp\n";
    for(int i=0;i<ts.size();i++){
        cout<<i+1<<" "<<ts[i]<<endl; 
    }
    
    for(int i = 0;i<request.size();i++){
        cout<<"\nrequest from site "<<request[i]<<endl;
        for(int j=0;j<ts.size();j++){
            if(request[i]!=(j+1)){
                if(ts[j]>ts[request[i]-1] || ts[j]==0)
                    cout<<j+1<<" replied\n";
                else
                    cout<<j+1<<" delayed\n";
            
            }
        }
    }
    
    cout<<endl;
    map<int,int>::iterator it;
    it= mp.begin();
    int c = 0;
    for(it=mp.begin();it!=mp.end();it++){
        cout<<"site "<<it->second<<" enterred critical section\n";
        if(c==0)
            cout<<"\nSimilarly\n\n";
        c++;
    }


    return 0;
}