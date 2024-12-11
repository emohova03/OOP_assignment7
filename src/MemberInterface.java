interface MemberInterface {
    String getId();
    String getInfo();
    boolean borrowItem(LibraryItem item);
    void returnItem(LibraryItem item);
}
