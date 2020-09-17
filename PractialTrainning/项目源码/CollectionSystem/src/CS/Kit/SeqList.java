package CS.Kit;

public class SeqList <T>
{
	protected Object[] element;
	protected int n;
	
	public SeqList(int length)
	{
		this.element = new Object[length];
		this.n = 0;		//˳���ĳ���
	}
	
	public SeqList()
	{
		this(64);
	}
	
	public SeqList(T[] values)
	{
		this(values.length);
		
		for(int i=0;i<values.length;i++)
		{
			this.element[i] = values[i];
		}
		this.n = element.length;
	}
	
	public boolean isEmpty()
	{
		if(this.n == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public T[] get(int i)
	{
		if(i>=0&&i<this.n)
		{
			return (T[])this.element[i];
		}
		else
		{
			return null;
		}
	}
	
	public void set(int i,T x)
	{
		if(x==null)
		{
			throw new NullPointerException("x==new");
		}
		if(i>=0&&i<this.n)
		{
			this.element[i]=x;
		}
		else
		{
			throw new java.lang.IndexOutOfBoundsException(i+"");
		}
	}
	
	public int insert(int where,T x)
	{
		Object temp[] = this.element;
		
		if(x==null)
		{
			throw new NullPointerException("x==null");
		}
		
		if(where<0)
		{
			where=0;
		}
		
		if(where>this.n)
		{
			where=this.n;
		}
		
		if(this.n==element.length)
		{
			this.element=new Object[temp.length*2];
			for(int i=0;i<temp.length;i++)
			{
				this.element[i] = temp[i];
			}
		}
		
		for(int i=this.n-1;i>=where;i--)
		{
			this.element[i+1] = temp[i];
		}
		
		this.element[where]=x;
		this.n++;
		return where;
	}
	
	public int insert(T x)
	{
		this.insert(this.n,x);
		return this.n;
	}
	
	public T remove(int where)
	{
		if(this.n>0 && where>=0 && where<this.n);
		{
			T old = (T)this.element[where];
			for(int i=where;i<this.n-1;i++)
			{
				this.element[i]=this.element[i+1];
			}
			this.element[this.n-1]=null;
			this.n--;
			return old;
		}
	}
	
	public void clear()
	{
		this.n=0;
	}

	public int search(T key)
	{
		int flag = -1;
		int test = 0;
		for(int i=0;i<this.n;i++)
		{
			test++;
			if(key.equals(this.element[i]))
			{
				flag = i;
			}
		}
		System.out.println("��ѯ������"+test);
		return flag;
	}
	
	/************����Ƿ���key�ؼ���************/
	public boolean contains(T key)
	{
		return (search(key)!=-1);
	}
	
	/************���벻�ظ�Ԫ��************/
	public int insertDifferent(T x)
	{
		int flag = -1;
		if(!contains(x))
		{
			insert(x);
			flag = 0;
		}
		return flag;
	}
	
	/************�Ƚ��������Ա��Ƿ���ͬ************/
	public boolean equals(Object obj)
	{
		boolean flag=true;
		SeqList<?> sl = (SeqList<?>)obj;
		if(this.n!=sl.n)
		{
			flag=false;
		}
		else
		{
			for(int i=0;i<this.n;i++)
			{
				if(this.get(i)!=sl.get(i))
				{
					flag=false;
					break;
				}
			}
		}
		return flag;
	}
	
	/************��this���Ա��в����������������Ա�************/
	public void addAll(SeqList<?> sl)
	{
		for(int i=0;i<sl.n;i++)
		{
			this.insert((T)sl.get(i));
		}
	}
	
	/************�����Ա��з��س���************/
	public int size()
	{
		return this.n;
	}
	
	/************��this���Ա��в����������ظ��������Ա�************/
	public void addAllDifferent(SeqList<?> sl)
	{
		for(int i=0;i<sl.n;i++)
		{
			this.insertDifferent((T)sl.get(i));
		}
	}
	
	public Object[][] putList()
	{
		Object temp[][] = new Object[n][];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<this.get(i).length;j++)
			{
				temp[i][j]=this.get(i)[j];
			}
		}
		return temp;
	}
	
	/************��дtoString����************/
	public String toString() 
	{
		String str = this.getClass().getName()+"(";
		for(int i=0;i<this.n;i++)
		{
			if(i==0)
			{
				str =str+this.element[i].toString();
				continue;
			}
			str =str+","+this.element[i].toString();
		}
		return str+")";
	}
	
	public String toPreviousString()
	{
		return "SeqList [toPreviousString()=" + toPreviousString() + "]";
	}
}
