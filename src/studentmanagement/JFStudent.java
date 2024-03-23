package studentmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class JFStudent extends javax.swing.JFrame {

    List<Student> list = new ArrayList<Student>();
    Student x;
    private int pos = 0;
    private int check = 0;
    String avatarURL = "../Data/avatar.png";
    String dataPath = "data.bin";
    JPanel panel;

    public JFStudent() {
        initComponents();

        this.jPanel2.setBackground(Color.LIGHT_GRAY);
        this.jPanel3.setBackground(Color.LIGHT_GRAY);

        loadStudentsFromBinaryFile(dataPath);
        View();
        ViewTable();
        sortTable();
    }

    private void loadStudentsFromBinaryFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Đọc danh sách sinh viên từ file và gán vào biến list
            while (true) {
                DefaultTableModel model = (DefaultTableModel) this.tblStudent.getModel();
                Student s;
                try {
                    s = (Student) ois.readObject();
                    list.add((Student) s);

                    model.addRow(new Object[]{list.size(),
                        s.getMHS(), s.getTenHS(), s.getDiem(), s.getDiaChi(), s.getGhiChu()});

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void View() {
        if (!list.isEmpty()) {
            x = list.get(pos);
            this.txtMaHS.setText(x.getMHS());
            this.txtTenHS.setText(x.getTenHS());
            this.txtDiem.setText("" + x.getDiem());
            ImageIcon defaultIcon = new ImageIcon(x.getUrlAvatar());
            Image image = defaultIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            this.btnHinhAnh.setIcon(new ImageIcon(image));
            this.txtDiaChi.setText(x.getDiaChi());
            this.txtGhiChu.setText(x.getGhiChu());
        } else {
            ImageIcon defaultIcon = new ImageIcon(avatarURL);
            Image image = defaultIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            btnHinhAnh.setIcon(new ImageIcon(image));
        }

        OnOff(true, false);
    }

    public void ViewTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblStudent.getModel();
        model.setNumRows(0);
        int n = 1;
        for (Student x : list) {
            model.addRow(new Object[]{n++, x.getMHS(), x.getTenHS(), x.getDiem(), x.getDiaChi(), x.getGhiChu()});
        }

        this.tblStudent.setRowHeight(20);

        // Đặt độ rộng cố định cho cột thứ nhất
        TableColumnModel columnModel = tblStudent.getColumnModel();
        TableColumn firstColumn = columnModel.getColumn(0);
        firstColumn.setPreferredWidth(10); // Đặt độ rộng cố định là 10px
        TableColumn thirdColumn = columnModel.getColumn(3);
        thirdColumn.setPreferredWidth(10);

        // Căn giữa nội dung của cột 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblStudent.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblStudent.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    public void sortTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblStudent.getModel());
        tblStudent.setRowSorter(sorter);

        //Áp dụng riêng cho cột "Điểm"
        sorter.setComparator(3, new Comparator<Float>() {
            @Override
            public int compare(Float f1, Float f2) {
                return Float.compare(f1, f2);
            }
        });
    }

    public void OnOff(boolean a, boolean b) {
        this.btnSave.show(b);
        this.btnCancel.show(b);

        this.btnAdd.show(a);
        this.btnDelete.show(a);
        this.btnEdit.show(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaHS = new javax.swing.JTextField();
        txtTenHS = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtGhiChu = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHinhAnh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chương trình quản lý học sinh");
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mã học sinh:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tên học sinh:");

        txtMaHS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTenHS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setText("Cập nhật");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancel.setText("Hủy bỏ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Điểm:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ghi chú:");

        btnHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHinhAnh.setToolTipText("Chọn hình ảnh");
        btnHinhAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenHS))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi)
                                    .addComponent(txtDiem)
                                    .addComponent(txtGhiChu)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(txtMaHS))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit)
                        .addComponent(btnAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tblStudent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "Điểm", "Địa chỉ", "Ghi chú"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        tblStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        btnImport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnExport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnSaveAs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSaveAs.setText("Save as");
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImport)
                    .addComponent(btnExport)
                    .addComponent(btnSaveAs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
        int n = JOptionPane.showConfirmDialog(panel, "Bạn có muốn xóa không?", "Alert", JOptionPane.YES_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            list.remove(pos);
            if (pos > list.size() - 1) {
                pos = pos - 1;
            }
            if (pos < 0) {
                pos = 0;
            }
            View();
            ViewTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.txtMaHS.setText("");
        this.txtTenHS.setText("");
        this.txtDiem.setText("");
        this.txtDiaChi.setText("");
        this.txtGhiChu.setText("");
        avatarURL = "../Data/avatar.png";
        ImageIcon defaultIcon = new ImageIcon(avatarURL);
        Image image = defaultIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        btnHinhAnh.setIcon(new ImageIcon(image));

        check = 1;
        OnOff(false, true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        check = -1;
        OnOff(false, true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        // Khởi tạo JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Chỉ định rằng chỉ có thể chọn file
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Chỉ hiển thị các file có phần mở rộng là .csv
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        fileChooser.setFileFilter(filter);

        // Hiển thị hộp thoại và lấy kết quả khi người dùng chọn file hoặc hủy bỏ
        int result = fileChooser.showOpenDialog(this);

        // Kiểm tra xem người dùng đã chọn file hay chưa
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn đến file được chọn
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            try {
                // Khởi tạo đối tượng BufferedReader để đọc dữ liệu từ file CSV
                BufferedReader br = new BufferedReader(new FileReader(filePath));

                // Biến để lưu dòng đọc được từ file
                String line;

                while ((line = br.readLine()) != null) {
                    // Tách dữ liệu trong dòng thành các trường sử dụng dấu phẩy làm delimiter
                    String[] data = line.split(",");
                    Student student = new Student(data[0], data[1], Float.parseFloat(data[2]), data[3], data[4], data[5]);
                    list.add(student);
                }

                br.close();
                ViewTable();

                JOptionPane.showMessageDialog(this, "Import danh sách học sinh thành công!");
            } catch (IOException e) {
                // Xử lý ngoại lệ nếu có
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    //Export file
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu và tên file");

        // Mặc định là lưu với định dạng CSV
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".csv")) {
                    filePath += ".csv"; // Đảm bảo rằng tên file có đuôi là .csv
                }
                FileWriter fw = new FileWriter(filePath);
                fw.write("Mã học sinh,Tên học sinh,Điểm,Hình ảnh,Địa chỉ,Ghi chú\n"); // Ghi header

                for (Student student : list) {
                    fw.write(student.getMHS() + "," + student.getTenHS() + "," + student.getDiem() + ","
                            + student.getUrlAvatar() + "," + student.getDiaChi() + "," + student.getGhiChu() + "\n");
                }
                fw.close();
                JOptionPane.showMessageDialog(this, "Xuất file thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Xuất file thất bại: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        pos = tblStudent.getSelectedRow(); //Để lấy vị trí con trỏ chuột trỏ vào hiện qua bên View
        View();
    }//GEN-LAST:event_tblStudentMouseClicked

    private void tblStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentKeyReleased
        // TODO add your handling code here:
        pos = tblStudent.getSelectedRow();
        View();
    }//GEN-LAST:event_tblStudentKeyReleased

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String MHS = this.txtMaHS.getText();
        String TenHS = this.txtTenHS.getText();
        float Diem = Float.parseFloat(this.txtDiem.getText());
        String DiaChi = this.txtDiaChi.getText();
        String GhiChu = this.txtGhiChu.getText();
        String HinhAnh = avatarURL;

        // Kiểm tra điều kiện rỗng và điểm
        if (MHS.isEmpty() || TenHS.isEmpty() || DiaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ. Vui lòng kiểm tra lại.");
            return; // Dừng lại ở đây nếu điều kiện không được thỏa mãn
        }
        if (Diem < 0 || Diem > 10) {
            JOptionPane.showMessageDialog(this, "Điểm số không hợp lệ. Vui lòng kiểm tra lại.");
            return; // Dừng lại ở đây nếu điều kiện không được thỏa mãn
        }

        //TH1: Thêm
        if (check == 1) {
            boolean MHSExists = false;
            for (Student student : list) {
                if (student.getMHS().equals(MHS)) {
                    MHSExists = true;
                    break;
                }
            }
            if (!MHSExists) {
                list.add(new Student(MHS, TenHS, Diem, HinhAnh, DiaChi, GhiChu));
            } else {
                // Hiển thị thông báo cho người dùng rằng MHS đã tồn tại
                JOptionPane.showMessageDialog(this, "Mã học sinh đã tồn tại!");
            }
        }
        //TH2: Sửa 
        if (check == -1) {
            list.set(pos, new Student(MHS, TenHS, Diem, HinhAnh, DiaChi, GhiChu));
        }
        View();
        ViewTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        View();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        // TODO add your handling code here:
        List<Student> tempList = new ArrayList<>(list);

        try {
            // Mở file để ghi mới
            FileOutputStream ofs = new FileOutputStream(dataPath);
            ObjectOutputStream objOut = new ObjectOutputStream(ofs);

            // Ghi toàn bộ danh sách mới vào file
            for (Student s : tempList) {
                objOut.writeObject(s);
            }

            // Đóng luồng ghi và hiển thị thông báo
            objOut.close();
            this.setTitle("Main Screen");
            JOptionPane.showMessageDialog(this,
                    "Save successfully!", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            // Hiển thị lỗi nếu quá trình ghi dữ liệu vào file thất bại
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Save failed! Error: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void btnHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHinhAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        // Thiết lập chỉ chọn file hình ảnh
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png") || file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg");
            }

            public String getDescription() {
                return "Image Files (*.png, *.jpg, *.jpeg)";
            }
        });

        // Hiển thị hộp thoại chọn file
        int result = fileChooser.showOpenDialog(this);

        // Kiểm tra nếu người dùng đã chọn một file
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn của file được chọn
            File selectedFile = fileChooser.getSelectedFile();

            // Cập nhật đường dẫn hình ảnh
            avatarURL = selectedFile.getAbsolutePath();

            ImageIcon imageIcon = new ImageIcon(avatarURL);
            Image image = imageIcon.getImage(); // Chuyển đổi ImageIcon thành Image
            Image newImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // Đổi kích thước hình ảnh
            ImageIcon newIcon = new ImageIcon(newImage); // Tạo ImageIcon mới từ Image đã được đổi kích thước
            btnHinhAnh.setIcon(newIcon);
        }
    }//GEN-LAST:event_btnHinhAnhMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel btnHinhAnh;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHS;
    private javax.swing.JTextField txtTenHS;
    // End of variables declaration//GEN-END:variables
}
