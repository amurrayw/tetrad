package edu.cmu.tetrad.algcomparison.continuous.pag;

import edu.cmu.tetrad.algcomparison.Algorithm;
import edu.cmu.tetrad.data.CovarianceMatrixOnTheFly;
import edu.cmu.tetrad.data.DataSet;
import edu.cmu.tetrad.graph.Graph;
import edu.cmu.tetrad.search.*;

import java.util.Map;

/**
 * Created by jdramsey on 6/4/16.
 */
public class ContinuousGfci implements Algorithm {
    public Graph search(DataSet dataSet, Map<String, Number> parameters) {
        Score score = new SemBicScore(new CovarianceMatrixOnTheFly(dataSet));
        GFci pc = new GFci(score);
        return pc.search();
    }

    public String getName() {
        return "c-GFCI";
    }

    @Override
    public Graph getComparisonGraph(Graph dag) {
        return new DagToPag(dag).convert();
    }

    public String getDescription() {
        return "GFCI, assuming the data are continuous. Uses SEM BIC score.";
    }}
