package jpl.ch01.ex15;

interface Lookup {
    /** 
     * nameと関連付けされた値を返す。
     * そのような値がなければnullを返す 
	 *
	 * @param name 名前
	 * @return 関連付けされた値、もくしはnull
	 * @throws NullPointerException nameがnullの場合
     */
    Object find(String name);
}
