package com.cash_book.model;

import java.util.List;

public interface IDAO {
	abstract public List<String> select(String sql);
	abstract public boolean insert(String sql);
	abstract public boolean delete(String sql);
}
