
package Vistas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VFormJuego extends javax.swing.JFrame{

    //private PJuego presentador;
    public VFormJuego() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpPrincipal = new javax.swing.JTabbedPane();
        pInicio = new javax.swing.JPanel();
        btnIniciarPartida = new javax.swing.JButton();
        btnReiniciarPartida = new javax.swing.JButton();
        lblBienvenida = new javax.swing.JLabel();
        pModoJuego = new javax.swing.JPanel();
        btnJugadorPc = new javax.swing.JButton();
        btnJugador1y2 = new javax.swing.JButton();
        lblModoJuego = new javax.swing.JLabel();
        pJugador = new javax.swing.JPanel();
        lblJugador = new javax.swing.JLabel();
        btnJugador1 = new javax.swing.JButton();
        btnJugador2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        lblCambiarTurno = new javax.swing.JLabel();
        btnFinalizarPartida = new javax.swing.JButton();
        btnGuardarPartida = new javax.swing.JButton();
        btnRetrocederJugada = new javax.swing.JButton();
        btnFinalizarTurno = new javax.swing.JButton();
        txtCeroCero = new javax.swing.JTextField();
        txtCeroUno = new javax.swing.JTextField();
        txtCeroDos = new javax.swing.JTextField();
        txtUnoCero = new javax.swing.JTextField();
        txtUnoUno = new javax.swing.JTextField();
        txtUnoDos = new javax.swing.JTextField();
        txtDosCero = new javax.swing.JTextField();
        txtDosUno = new javax.swing.JTextField();
        txtDosDos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbpPrincipal.setName("JUEGO");
        tbpPrincipal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbpPrincipalAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnIniciarPartida.setText("INICIAR PARTIDA");
        btnIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPartidaActionPerformed(evt);
            }
        });

        btnReiniciarPartida.setText("REINICIAR PARTIDA");

        lblBienvenida.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblBienvenida.setText("¡BIENVENIDOS AL JUEGO!");

        javax.swing.GroupLayout pInicioLayout = new javax.swing.GroupLayout(pInicio);
        pInicio.setLayout(pInicioLayout);
        pInicioLayout.setHorizontalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addGroup(pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInicioLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblBienvenida))
                    .addGroup(pInicioLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReiniciarPartida)
                            .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pInicioLayout.setVerticalGroup(
            pInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInicioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblBienvenida)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReiniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        tbpPrincipal.addTab("Inicio", pInicio);

        btnJugadorPc.setText("JUGADOR VS PC");
        btnJugadorPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadorPcActionPerformed(evt);
            }
        });

        btnJugador1y2.setText("JUGADOR1 VS JUGADOR2");
        btnJugador1y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador1y2ActionPerformed(evt);
            }
        });

        lblModoJuego.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblModoJuego.setText("SELECCIONE SU MODO DE JUEGO");

        javax.swing.GroupLayout pModoJuegoLayout = new javax.swing.GroupLayout(pModoJuego);
        pModoJuego.setLayout(pModoJuegoLayout);
        pModoJuegoLayout.setHorizontalGroup(
            pModoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pModoJuegoLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblModoJuego)
                .addGap(19, 19, 19))
            .addGroup(pModoJuegoLayout.createSequentialGroup()
                .addGroup(pModoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pModoJuegoLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnJugadorPc))
                    .addGroup(pModoJuegoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnJugador1y2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pModoJuegoLayout.setVerticalGroup(
            pModoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pModoJuegoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblModoJuego)
                .addGap(18, 18, 18)
                .addComponent(btnJugadorPc)
                .addGap(18, 18, 18)
                .addComponent(btnJugador1y2)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        tbpPrincipal.addTab("ModoJuego", pModoJuego);

        lblJugador.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblJugador.setText("SELECCIONE EL JUGADOR");

        btnJugador1.setText("JUGADOR1 (X)");
        btnJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador1ActionPerformed(evt);
            }
        });

        btnJugador2.setText("JUGADOR2 (O)");
        btnJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pJugadorLayout = new javax.swing.GroupLayout(pJugador);
        pJugador.setLayout(pJugadorLayout);
        pJugadorLayout.setHorizontalGroup(
            pJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadorLayout.createSequentialGroup()
                .addGroup(pJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJugadorLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblJugador))
                    .addGroup(pJugadorLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(pJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnJugador2)
                            .addComponent(btnJugador1))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pJugadorLayout.setVerticalGroup(
            pJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblJugador)
                .addGap(26, 26, 26)
                .addComponent(btnJugador1)
                .addGap(18, 18, 18)
                .addComponent(btnJugador2)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        tbpPrincipal.addTab("Jugador", pJugador);

        jPanel1.setPreferredSize(new java.awt.Dimension(335, 385));

        lblTurno.setText("TURNO DE:");

        btnFinalizarPartida.setText("<html><center>Finalizar Partida<html>");
        btnFinalizarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPartidaActionPerformed(evt);
            }
        });

        btnGuardarPartida.setText("<html><center>Guardar Partida<html>");

        btnRetrocederJugada.setText("<html><center>Retroceder Jugada<html>");

        btnFinalizarTurno.setText("Finalizar Turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinalizarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeroCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRetrocederJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUnoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCeroDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDosDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCeroUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblTurno)
                        .addGap(18, 18, 18)
                        .addComponent(lblCambiarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtDosCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtDosUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarTurno)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurno)
                    .addComponent(lblCambiarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetrocederJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCeroCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeroUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCeroDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDosDos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDosUno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDosCero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarTurno)
                .addContainerGap())
        );

        tbpPrincipal.addTab("Juego 3 en Raya", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPartidaActionPerformed
        tbpPrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_btnIniciarPartidaActionPerformed

    private void tbpPrincipalAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbpPrincipalAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbpPrincipalAncestorAdded

    private void btnJugadorPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadorPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJugadorPcActionPerformed

    private void btnJugador1y2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador1y2ActionPerformed
        tbpPrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_btnJugador1y2ActionPerformed

    private void btnJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador1ActionPerformed
        String jugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
        String jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2");
        tbpPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_btnJugador1ActionPerformed

    private void btnJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador2ActionPerformed
        String jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2");
        String jugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
        tbpPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_btnJugador2ActionPerformed

    private void btnFinalizarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPartidaActionPerformed

    }//GEN-LAST:event_btnFinalizarPartidaActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VFormJuego().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarPartida;
    private javax.swing.JButton btnFinalizarTurno;
    private javax.swing.JButton btnGuardarPartida;
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnJugador1;
    private javax.swing.JButton btnJugador1y2;
    private javax.swing.JButton btnJugador2;
    private javax.swing.JButton btnJugadorPc;
    private javax.swing.JButton btnReiniciarPartida;
    private javax.swing.JButton btnRetrocederJugada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblCambiarTurno;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblModoJuego;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pInicio;
    private javax.swing.JPanel pJugador;
    private javax.swing.JPanel pModoJuego;
    private javax.swing.JTabbedPane tbpPrincipal;
    private javax.swing.JTextField txtCeroCero;
    private javax.swing.JTextField txtCeroDos;
    private javax.swing.JTextField txtCeroUno;
    private javax.swing.JTextField txtDosCero;
    private javax.swing.JTextField txtDosDos;
    private javax.swing.JTextField txtDosUno;
    private javax.swing.JTextField txtUnoCero;
    private javax.swing.JTextField txtUnoDos;
    private javax.swing.JTextField txtUnoUno;
    // End of variables declaration//GEN-END:variables
}
