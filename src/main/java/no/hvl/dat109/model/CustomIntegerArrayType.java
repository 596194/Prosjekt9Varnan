package no.hvl.dat109.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.mapping.Array;
import org.hibernate.usertype.UserType;

public class CustomIntegerArrayType implements UserType {
	
    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }

    @Override
    public Class<Integer[]> returnedClass() {
        return Integer[].class;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
      throws HibernateException, SQLException {
        Array array = (Array) rs.getArray(names[0]);
        return array != null ? ((java.sql.Array) array).getArray() : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
      throws HibernateException, SQLException {
        if (value != null && st != null) {
            //Array array = (Array) session.connection().createArrayOf("int", (Integer[])value);
            //st.setArray(index, (java.sql.Array) array);
        } else {
            st.setNull(index, sqlTypes()[0]);
        }
    }

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		if (x == null) {
            return y == null;
        }
        return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return x.hashCode();
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return (Serializable) this.deepCopy(value);
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return this.deepCopy(cached);
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return original;
	}

	@Override
	public int getSqlType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    //implement equals, hashCode, and other methods 
}
