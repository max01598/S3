package hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class MDHashTable<K, V> extends  AbstractHashTable<K,V> implements Map<K, V>{
	
	
	/**
	 * Constructs an empty hashtable with an initial capacity of 4.
	 *
	*/
	public MDHashTable() {
		// TODO Auto-generated constructor stub
		this.size=0;
		this.table=new List[4];
		for(int i=0;i<4;i++)
		{
			this.table[i]= new ArrayList<Mapping<K,V>>();
		}
	}

	@Override
	public V put(K key, V value) {
		if(key==null || value ==null)
		{
			throw new NullPointerException();
		}
		
		int hashKey = key.hashCode();
		int indexe = hashKey%table.length;
		V valeurretour=null;
		
		for(int i=0;i<this.table[indexe].size();i++)
		{
			if(table[indexe].get(i).getKey().equals(key))
			{
				valeurretour=table[indexe].get(i).getValue();
				table[indexe].get(i).setValue(value);
				return valeurretour;
			}
		}
		
		table[indexe].add(new Mapping(key, value));
		this.size=size+1;
		
		double taille=this.size;//nb element
		double capacite=this.table.length;
		if((taille/capacite)>=0.80)
		{
			doublerCapacite();
		}
		
		return valeurretour;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		if(key==null)
		{
			throw new NullPointerException();
		}
		int hashKey = key.hashCode();
		int indexe = hashKey%table.length;
		V valeurretour=null;
		for(int i=0;i<this.table[indexe].size();i++)
		{
			if(table[indexe].get(i).getKey().equals(key))
			{
				valeurretour=table[indexe].get(i).getValue();
				return valeurretour;
			}
		}
		return valeurretour;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String contenu="{";
		for(int i=0;i<this.table.length;i++)
		{
			for(int y=0;y<this.table[i].size();y++)
			{
				
				if(y==(this.table[i].size()-2))
				{
					contenu=contenu+this.table[i].get(y).getKey()+"="+this.table[i].get(y).getValue();
				}
				else
				{
					contenu=contenu+this.table[i].get(y).getKey()+"="+this.table[i].get(y).getValue()+",";
				}
			}
		}
		contenu=contenu+"}";
		return contenu;
	}
	
	
	public void doublerCapacite()
	{
		List<Mapping<K,V>>[] table2;
		table2=new List[this.table.length*2];
		for(int i=0;i<(this.table.length*2);i++)
		{
			table2[i]= new ArrayList<Mapping<K,V>>();
		}
		
		for(int i=0;i<this.table.length;i++)
		{
			for(int y=0;y<this.table[i].size();y++)
			{
				int hashKey = this.table[i].get(y).getKey().hashCode();
				int indexe = hashKey%table2.length;
				table2[indexe].add(new Mapping(this.table[i].get(y).getKey(),this.table[i].get(y).getValue()));
			}
		}
		this.table=table2;
		
	}
	
	
	private class HashIterator implements Iterator<Mapping<K,V>>
	{
		
		private int[] tabInt;
		private int cptNext;
		public HashIterator() {
			tabInt=new int[table.length];
			tabInt[0]=table[0].size();
			for(int i=1;i<table.length;i++)
			{
				tabInt[i]=table[i].size()+tabInt[i-1];
			}
			this.cptNext=0;
			
		}
		@Override
		public boolean hasNext() {
			boolean next=true;
					if(cptNext==tabInt[table.length-1])
					{
						next=false;
					}
			return next;
		}

		@Override
		public Mapping<K, V> next() {
			Mapping<K, V> valeurRetour=null;
			for(int i=0;i<tabInt.length;i++)
			{
				if(tabInt[i]==cptNext)
				{
					if(tabInt[i]!=tabInt[i+1])
					{
						valeurRetour=table[i+1].get(0);
						break;
					}
					
				}
				else if(i==0 && tabInt[i]>cptNext)
				{
					valeurRetour=table[i].get(cptNext);
					break;
				}
				else if(tabInt[i]>cptNext)
				{
					valeurRetour=table[i].get(cptNext-tabInt[i-1]);
					break;
				}
			}
			cptNext++;
			return valeurRetour;
		}
		
		
		
	}
	

	public Iterator<Mapping<K, V>> iterator() {
        return new HashIterator();
	}

	
	
	
	@Override
	public int size() {
		int size=0;
		for(int i=0;i<this.table.length;i++)
		{
			for(int y=0;y<this.table[i].size();y++)
			{
				size=size+1;
			}
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
