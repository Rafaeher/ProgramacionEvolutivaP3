package presentacion;



import java.util.ArrayList;

import javax.swing.JOptionPane;
import configuracion.Bloating_enum;
import configuracion.Configuracion;
import configuracion.Genotipo_enum;
import configuracion.IniArbol_enum;
import configuracion.Mutacion_enum;
import configuracion.Reproduccion_enum;
import configuracion.Seleccion_enum;
import utils.Operacion;
import utils.OperacionesSeleccionadas;

/**
 *
 * @author carlo
 */
public class PanelInfo extends javax.swing.JPanel {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form NewJPanel
     */
    public PanelInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextFieldPoblacion = new javax.swing.JTextField();
        jLabelPoblacion = new javax.swing.JLabel();
        jLabelGeneraciones = new javax.swing.JLabel();
        jTextFieldGeneraciones = new javax.swing.JTextField();
        jLabelSeleccion = new javax.swing.JLabel();
        jComboBoxSeleccion = new javax.swing.JComboBox<>();
        jComboBoxCruce = new javax.swing.JComboBox<>();
        jLabelCruce = new javax.swing.JLabel();
        jLabelCruceporcentaje = new javax.swing.JLabel();
        jTextFieldCruceporcentaje = new javax.swing.JTextField();
        jLabelProbMutacion = new javax.swing.JLabel();
        jTextFieldProbMutacion = new javax.swing.JTextField();
        jTextFieldElite = new javax.swing.JTextField();
        jLabelElite = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButtonRun = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldProfundidad = new javax.swing.JTextField();
        jComboBoxMutacion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabelFunciones = new javax.swing.JLabel();
        jCheckBoxSuma = new javax.swing.JCheckBox();
        jCheckBoxResta = new javax.swing.JCheckBox();
        jCheckBoxRaiz = new javax.swing.JCheckBox();
        jCheckBoxMultiplicacion = new javax.swing.JCheckBox();
        jCheckBoxDivision = new javax.swing.JCheckBox();
        jCheckBoxLog = new javax.swing.JCheckBox();
        jCheckBoxA = new javax.swing.JCheckBox();
        jCheckBoxB = new javax.swing.JCheckBox();
        jCheckBoxOpuesto = new javax.swing.JCheckBox();
        jLabelBloating = new javax.swing.JLabel();
        jComboBoxBloating = new javax.swing.JComboBox<>();
        jComboBoxIniArbol = new javax.swing.JComboBox<>();
        jLabelIniArbol = new javax.swing.JLabel();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(450, 200));

        jTextFieldPoblacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jTextFieldPoblacion.setToolTipText("Introduce el tama�o de la poblaci�n (valor entero)");
        jTextFieldPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPoblacionActionPerformed(evt);
            }
        });

        jLabelPoblacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelPoblacion.setText("Tama�o de la poblaci�n");

        jLabelGeneraciones.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelGeneraciones.setText("N�mero de generaciones");

        jTextFieldGeneraciones.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jTextFieldGeneraciones.setToolTipText("Introduce el numero de generaciones (valor entero)");
        jTextFieldGeneraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGeneracionesActionPerformed(evt);
            }
        });

        jLabelSeleccion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelSeleccion.setText("Selecci�n");

        jComboBoxSeleccion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jComboBoxSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruleta", "Estocastica", "Truncamiento", "Torneo Deterministico",
        		"Torneo Probabilistico"}));
        jComboBoxSeleccion.setToolTipText("Elige un m�todo de seleccion");
        jComboBoxSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionActionPerformed(evt);
            }
        });

        jComboBoxCruce.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jComboBoxCruce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cruce arbol"}));
        jComboBoxCruce.setToolTipText("Selecciona un mecanismo de cruce");
        jComboBoxCruce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxCruce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCruceActionPerformed(evt);
            }
        });

        jLabelCruce.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelCruce.setText("Cruce");

        jLabelCruceporcentaje.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelCruceporcentaje.setText("Cruce %");

        jTextFieldCruceporcentaje.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jTextFieldCruceporcentaje.setToolTipText("Selecciona un porcentaje de cruce");
        jTextFieldCruceporcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCruceporcentajeActionPerformed(evt);
            }
        });

        jLabelProbMutacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelProbMutacion.setText("Prob Mutacion");

        jTextFieldProbMutacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jTextFieldProbMutacion.setToolTipText("Selecciona un porcentaje de cruce");
        jTextFieldProbMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProbMutacionActionPerformed(evt);
            }
        });

        jTextFieldElite.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jTextFieldElite.setToolTipText("Selecciona un porcentaje de cruce");
        jTextFieldElite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEliteActionPerformed(evt);
            }
        });

        jLabelElite.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelElite.setText("�lite");

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(239, 234, 234));
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setAutoscrolls(false);
        jScrollPane4.setViewportView(jTextArea4);

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Profundidad m�xima");

        jComboBoxMutacion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jComboBoxMutacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "De arbol", "Funcional simple", "Terminal simple", "Permutacion" }));
        jComboBoxMutacion.setToolTipText("Selecciona un mecanismo de cruce");
        jComboBoxMutacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMutacionActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelFunciones.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelFunciones.setText("Funciones");

        jCheckBoxSuma.setText("+");
        jCheckBoxSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSumaActionPerformed(evt);
            }
        });

        jCheckBoxResta.setText("-");
        jCheckBoxResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRestaActionPerformed(evt);
            }
        });

        jCheckBoxRaiz.setText("sqrt");
        jCheckBoxRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRaizActionPerformed(evt);
            }
        });

        jCheckBoxMultiplicacion.setText("*");
        jCheckBoxMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMultiplicacionActionPerformed(evt);
            }
        });

        jCheckBoxDivision.setText("/");
        jCheckBoxDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDivisionActionPerformed(evt);
            }
        });

        jCheckBoxLog.setText("log");
        jCheckBoxLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLogActionPerformed(evt);
            }
        });

        jCheckBoxA.setText("A");
        jCheckBoxA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAActionPerformed(evt);
            }
        });

        jCheckBoxB.setText("B");
        jCheckBoxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBActionPerformed(evt);
            }
        });

        jCheckBoxOpuesto.setText("- (Opuesto)");
        jCheckBoxOpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxOpuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFunciones)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSuma)
                            .addComponent(jCheckBoxMultiplicacion))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBoxDivision)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxB))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBoxResta)
                                .addGap(48, 48, 48)
                                .addComponent(jCheckBoxA)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBoxRaiz)
                            .addComponent(jCheckBoxLog))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxOpuesto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFunciones)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSuma)
                    .addComponent(jCheckBoxResta)
                    .addComponent(jCheckBoxRaiz)
                    .addComponent(jCheckBoxA)
                    .addComponent(jCheckBoxOpuesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMultiplicacion)
                    .addComponent(jCheckBoxDivision)
                    .addComponent(jCheckBoxLog)
                    .addComponent(jCheckBoxB))
                .addGap(27, 27, 27))
        );

        jLabelBloating.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelBloating.setText("Bloating");

        jComboBoxBloating.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jComboBoxBloating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarpeian", "Penalizacion bien fundamentada" }));
        jComboBoxBloating.setToolTipText("Elige un m�todo de selecci�n");
        jComboBoxBloating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBloatingActionPerformed(evt);
            }
        });

        jComboBoxIniArbol.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jComboBoxIniArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completa", "Creciente", "Ramped and half" }));
        jComboBoxIniArbol.setToolTipText("Elige un m�todo de selecci�n");
        jComboBoxIniArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIniArbolActionPerformed(evt);
            }
        });

        jLabelIniArbol.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelIniArbol.setText("Inicializacion del �rbol");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButtonRun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelIniArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextFieldCruceporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCruce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPoblacion)
                                    .addComponent(jLabelGeneraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldGeneraciones)
                                    .addComponent(jTextFieldPoblacion))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelCruceporcentaje)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelCruce)))
                            .addComponent(jLabelElite, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldElite))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldProfundidad)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSeleccion)
                                            .addComponent(jLabel1))
                                        .addGap(27, 27, 27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldProbMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxSeleccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBloating)
                                            .addComponent(jLabelProbMutacion))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxBloating, 0, 1, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jComboBoxIniArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPoblacion)
                    .addComponent(jLabelSeleccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGeneraciones)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCruceporcentaje)
                    .addComponent(jLabelCruce)
                    .addComponent(jLabelProbMutacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCruceporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProbMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelElite)
                    .addComponent(jLabelBloating))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldElite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBloating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxIniArbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIniArbol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRun)
                .addContainerGap())
        );
        cosasPorDefecto();
    }// </editor-fold> 
    
	private void cosasPorDefecto() {

		this.jTextFieldProfundidad.setText("5");
		this.jTextFieldPoblacion.setText("300");
		this.jTextFieldCruceporcentaje.setText("60");
		this.jTextFieldGeneraciones.setText("200");
		this.jTextFieldProbMutacion.setText("8");
		this.jTextFieldElite.setText("5");
		selectAllJCheckBox();
		this.jTextArea4.setLineWrap(true);
		this.jTextArea4.setWrapStyleWord(true);
	}

	private void jTextFieldPoblacionActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void jTextFieldGeneracionesActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void jComboBoxSeleccionActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void jComboBoxCruceActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jTextFieldCruceporcentajeActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void jTextFieldProbMutacionActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void jTextFieldEliteActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               
                                       

    private void jComboBoxMutacionActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jCheckBoxSumaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jCheckBoxRestaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jCheckBoxRaizActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jCheckBoxMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void jCheckBoxDivisionActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jCheckBoxLogActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jComboBoxBloatingActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jCheckBoxAActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jCheckBoxBActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jCheckBoxOpuestoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jComboBoxIniArbolActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                       

	private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {
		if(Integer.parseInt(jTextFieldProfundidad.getText()) <= 1){
			JOptionPane.showMessageDialog(null, "Error: La profundidad debe ser mayor que 1", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if (this.jTextFieldPoblacion.getText().isEmpty() || jTextFieldGeneraciones.getText().isEmpty()
				|| jTextFieldCruceporcentaje.getText().isEmpty() || this.jTextFieldProbMutacion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: Faltan datos", "error", JOptionPane.ERROR_MESSAGE);
			
		} else {
			// String tipo = (String) this.jComboBoxTipo.getSelectedItem();
			// this.tipo = tipo;
			int tamano_poblacion = Integer.parseInt(this.jTextFieldPoblacion.getText());
			int num_generaciones = Integer.parseInt(this.jTextFieldGeneraciones.getText());
			String seleccion = (String) this.jComboBoxSeleccion.getSelectedItem();
			String cruce = (String) this.jComboBoxCruce.getSelectedItem();
			String mutacion = (String) this.jComboBoxMutacion.getSelectedItem();
			String bloating = (String) this.jComboBoxBloating.getSelectedItem();
			String iniArbol = (String) this.jComboBoxIniArbol.getSelectedItem();
			double cruceporcentaje = Double.parseDouble(this.jTextFieldCruceporcentaje.getText());
			double prob_mutacion = Double.parseDouble(this.jTextFieldProbMutacion.getText());
			int elite = Integer.parseInt(this.jTextFieldElite.getText());
			Seleccion_enum s = getSeleccion(seleccion);
			Reproduccion_enum r = getReproduccion(cruce);
			Genotipo_enum g = Genotipo_enum.ALFABETO;
			Mutacion_enum m = getMutacion(mutacion);
			Bloating_enum b = getBloating(bloating);
			IniArbol_enum arbol = getIniArbol(iniArbol);
			this.repaint();
			Configuracion c = new Configuracion(true, num_generaciones, prob_mutacion, r, m, s, g, cruceporcentaje,
					tamano_poblacion, elite, "", Integer.parseInt(jTextFieldProfundidad.getText()),b,
					getOperacionesSeleccionadas(),arbol);
			OperacionesSeleccionadas.setOperacionesSeleccionadas(getOperacionesSeleccionadas());
			Controlador controlador = new Controlador();
			controlador.execute(c);
			
		}
	}

	private Seleccion_enum getSeleccion(String s) {
		if (s.equalsIgnoreCase("Ruleta"))
			return Seleccion_enum.Ruleta;
		else if (s.equalsIgnoreCase("Estocastica"))
			return Seleccion_enum.Estocastica;
		else if (s.equalsIgnoreCase("Truncamiento"))
			return Seleccion_enum.Truncamiento;
		else if (s.equalsIgnoreCase("Torneo Deterministico"))
			return Seleccion_enum.Torneo_Deterministico;
		else if (s.equalsIgnoreCase("Torneo Probabilistico"))
			return Seleccion_enum.Torneo_Probabilistico;
		else
			return null;
	}

	private Reproduccion_enum getReproduccion(String s) {
		return Reproduccion_enum.CRUCE_ARBOL;
	}
	
	private IniArbol_enum getIniArbol(String s) {
		switch(s){
			case "Completa": return IniArbol_enum.COMPLETA;
			case "Creciente": return IniArbol_enum.CRECIENTE;
			case "Ramped and half": return IniArbol_enum.RAMPED_AND_HALF;
			default: return null;
		}
	}

	private Mutacion_enum getMutacion(String s) {
		switch (s) {
		case "De arbol":
			return Mutacion_enum.MUTACION_DE_ARBOL;
		case "Funcional simple":
			return Mutacion_enum.MUTACION_FUNCIONAL_SIMPLE;
		case "Terminal simple":
			return Mutacion_enum.MUTACION_TERMINAL_SIMPLE;
		case "Permutacion":
			return Mutacion_enum.PERMUTACION;
		default:
			return null;
		}

	}
	
	private Bloating_enum getBloating(String s) {
		switch(s){
		case "Tarpeian": return Bloating_enum.TARPEIAN;
		case "Penalizacion bien fundamentada": return Bloating_enum.PENALIZACION_BIEN_FUNDAMENTADA;
		default: return null;
		}
		
	}

	
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonRun;
    private javax.swing.JCheckBox jCheckBoxA;
    private javax.swing.JCheckBox jCheckBoxB;
    private javax.swing.JCheckBox jCheckBoxDivision;
    private javax.swing.JCheckBox jCheckBoxLog;
    private javax.swing.JCheckBox jCheckBoxMultiplicacion;
    private javax.swing.JCheckBox jCheckBoxOpuesto;
    private javax.swing.JCheckBox jCheckBoxRaiz;
    private javax.swing.JCheckBox jCheckBoxResta;
    private javax.swing.JCheckBox jCheckBoxSuma;
    private javax.swing.JComboBox<String> jComboBoxBloating;
    private javax.swing.JComboBox<String> jComboBoxCruce;
    private javax.swing.JComboBox<String> jComboBoxIniArbol;
    private javax.swing.JComboBox<String> jComboBoxMutacion;
    private javax.swing.JComboBox<String> jComboBoxSeleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBloating;
    private javax.swing.JLabel jLabelCruce;
    private javax.swing.JLabel jLabelCruceporcentaje;
    private javax.swing.JLabel jLabelElite;
    private javax.swing.JLabel jLabelFunciones;
    private javax.swing.JLabel jLabelGeneraciones;
    private javax.swing.JLabel jLabelIniArbol;
    private javax.swing.JLabel jLabelPoblacion;
    private javax.swing.JLabel jLabelProbMutacion;
    private javax.swing.JLabel jLabelSeleccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextFieldCruceporcentaje;
    private javax.swing.JTextField jTextFieldElite;
    private javax.swing.JTextField jTextFieldGeneraciones;
    private javax.swing.JTextField jTextFieldPoblacion;
    private javax.swing.JTextField jTextFieldProbMutacion;
    private javax.swing.JTextField jTextFieldProfundidad;
    // End of variables declaration     
	public void setTexto(String mensaje, String estadisticas) {
		jTextArea4.setText(mensaje + " " + estadisticas);
		
	}
	private void selectAllJCheckBox(){
		this.jCheckBoxDivision.setSelected(true);
		this.jCheckBoxMultiplicacion.setSelected(true);
		this.jCheckBoxRaiz.setSelected(true);
		this.jCheckBoxLog.setSelected(true);
		this.jCheckBoxResta.setSelected(true);
		this.jCheckBoxSuma.setSelected(true); 
		this.jCheckBoxOpuesto.setSelected(true);
		this.jCheckBoxA.setSelected(true);
		this.jCheckBoxB.setSelected(true);

	}
	private ArrayList<Operacion> getOperacionesSeleccionadas(){
		ArrayList<Operacion> array = new ArrayList<Operacion>();
		if(jCheckBoxDivision.isSelected()) array.add(Operacion.DIV);
		if(jCheckBoxMultiplicacion.isSelected()) array.add(Operacion.MUL);
		if(jCheckBoxRaiz.isSelected()) array.add(Operacion.SQRT);
		if(jCheckBoxLog.isSelected()) array.add(Operacion.LOG);
		if(jCheckBoxResta.isSelected()) array.add(Operacion.RESTA);
		if(jCheckBoxSuma.isSelected()) array.add(Operacion.SUMA);
		if(jCheckBoxA.isSelected()) array.add(Operacion.A);
		if(jCheckBoxB.isSelected()) array.add(Operacion.B);
		if(jCheckBoxOpuesto.isSelected()) array.add(Operacion.OPUESTO);
		return array;
	}

}
